/*
 * 文件名：HelloApi.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HelloApi.java
 * 修改人：xiaofan
 * 修改时间：2017年3月11日
 * 修改内容：新增
 */
package com.zxiaofan.dubboConsumer.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Wechat.dubboConsumer.Service.CoreService;
import com.Wechat.dubboConsumer.rsp.Article;
import com.Wechat.dubboConsumer.rsp.MusicMessage;
import com.Wechat.dubboConsumer.rsp.NewsMessage;
import com.Wechat.dubboConsumer.rsp.TextMessage;
import com.Wechat.dubboConsumer.utils.SignUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.zxiaofan.dubboConsumer.service.IConsumerService;
import com.zxiaofan.dubboProvidder.model.UserDo;

/**
 * 对外开放的Http接口.
 * 
 * 必须引入aopalliance-1.0.jar，否则服务启动虽不报错，但请求http服务可能404
 * 
 * produces="application/json;charset=utf-8":客户端只接收json且编码为utf-8
 * 
 * @author xiaofan
 */
@Controller
@RequestMapping
@Component
public class HelloApi {
    @Resource(name = "consumerService")
    private IConsumerService consumerService;

    @RequestMapping(value = "/api", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String boy(HttpServletRequest request, HttpServletResponse response) {
        String json = null;
        String result = null;
        StringBuffer buffer = new StringBuffer();
        String readLine = "";
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = request.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((readLine = bufferedReader.readLine()) != null) {
                // RequestMethod.POST模式时，readLine有值
                buffer.append(readLine);
            }
            json = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != inputStreamReader) {
                    inputStreamReader.close();
                }
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("api_param:" + json); // 入参
        result = consumerService.hi(json); // 业务处理
        return result;
    }
    
    @RequestMapping(value="/saveUser", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String saveUser(HttpServletRequest request,@RequestParam(required=false,defaultValue="123",value="userName") String userName,@RequestParam(required=false,defaultValue="123",value="userAge") String userAge){
    	String parameter1 = request.getParameter("userName");
    	String parameter2 = request.getParameter("userAge");
    	System.out.println(parameter1+parameter2);
    	System.out.println(userName+userAge);
    	UserDo userDo = new UserDo();
    	userDo.setTableName("user");
    	String str = consumerService.saveuser(userDo);
    	return str;
    }
    
    @RequestMapping(value="/wx")
    @ResponseBody
    public String getWechatRequest(HttpServletRequest request,HttpServletResponse response){
    	String str = null;
    	// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr"); 
        System.out.println("微信加密签名:"+signature);
        System.out.println("时间戳 :"+timestamp);
        System.out.println("随机数:"+nonce);
        System.out.println("随机字符串:"+echostr);
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
        	str = echostr;
		}
		return str;
    }
    
    
    
    @RequestMapping(value="/wx",method = RequestMethod.POST)
    @ResponseBody
    public String WechatRequest(HttpServletRequest request,HttpServletResponse response){
    	
    	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        response.setCharacterEncoding("GBK");  
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(request); 
//    	try {
//			Map<String, String> reqmap = parseXml(request);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	String str = null;
//    	// 微信加密签名  
//        String signature = request.getParameter("signature");  
//        // 时间戳  
//        String timestamp = request.getParameter("timestamp");  
//        // 随机数  
//        String nonce = request.getParameter("nonce");  
//        // 随机字符串  
//        String echostr = request.getParameter("echostr"); 
//        System.out.println("微信加密签名:"+signature);
//        System.out.println("时间戳 :"+timestamp);
//        System.out.println("随机数:"+nonce);
//        System.out.println("随机字符串:"+echostr);
//        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
//        	str = echostr;
//		}
		return respMessage;
    }
}
