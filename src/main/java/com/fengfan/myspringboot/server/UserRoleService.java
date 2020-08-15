package com.fengfan.myspringboot.server;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.fengfan.myspringboot.dao.UserRoleMapper;
import com.fengfan.myspringboot.pojo.UserRole;

@Service
public interface UserRoleService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(UserRole record);

    public int insertSelective(UserRole record);

    public UserRole selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(UserRole record);

    public int updateByPrimaryKey(UserRole record);

}
