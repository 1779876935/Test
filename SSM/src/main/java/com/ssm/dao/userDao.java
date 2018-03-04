package com.ssm.dao;

import java.util.List;

import com.ssm.daoInf.IBaseDaoInfImp;
import com.ssm.entity.user;

public class userDao extends IBaseDaoInfImp {
	public List<user> getUsers(){
		List<user> selectList = sqlSessionWrite.selectList("getUsers");
		return selectList;
	}
}
