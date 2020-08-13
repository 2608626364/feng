package com.fengfan.myspringboot.server;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fengfan.myspringboot.mapper.UserRoleMapper;
import com.fengfan.myspringboot.pojo.UserRole;
@Service
public class UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

}
