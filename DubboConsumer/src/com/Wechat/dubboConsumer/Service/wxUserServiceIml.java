package com.Wechat.dubboConsumer.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zxiaofan.dubboProvidder.model.UserDo;
import com.zxiaofan.dubboProvidder.service.IProviderService;
import com.zxiaofan.dubboProvidder.service.IUserService;
@Component("wxUserService")
public class wxUserServiceIml implements wxUserService{
	@Resource(name = "providerService")
    private IProviderService providerService;

    @Resource(name = "userService")
    private IUserService userService;
	@Override
	public String saveUser(UserDo userDo) {
		int insert = userService.insert(userDo);
		return insert+"";
	}

}
