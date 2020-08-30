package com.fengfan.user.server.impl;

import com.fengfan.user.dao.UserRoleMapper;
import com.fengfan.user.pojo.UserRole;
import com.fengfan.user.server.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserRoleServiceimpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }


    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }


    @Override
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

}
