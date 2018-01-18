package com.Wechat.dubboConsumer.Service;

import com.zxiaofan.dubboProvidder.model.UserDo;

public interface wxUserService {
	String saveUser(UserDo userDo);
}
