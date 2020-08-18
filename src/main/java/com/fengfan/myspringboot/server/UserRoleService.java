package com.fengfan.myspringboot.server;

import com.fengfan.myspringboot.pojo.UserRole;


public interface UserRoleService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(UserRole record);

    public int insertSelective(UserRole record);

    public UserRole selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(UserRole record);

    public int updateByPrimaryKey(UserRole record);

}
