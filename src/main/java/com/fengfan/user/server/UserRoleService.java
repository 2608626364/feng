package com.fengfan.user.server;

import com.fengfan.user.pojo.UserRole;


public interface UserRoleService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(UserRole record);

    public int insertSelective(UserRole record);

    public UserRole selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(UserRole record);

    public int updateByPrimaryKey(UserRole record);

}
