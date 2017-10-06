package com.muou.common.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.muou.common.entity.UserInfo;

@MapperScan
public interface UserInfoDao {
	public UserInfo getUserInfo(int userid);
}
