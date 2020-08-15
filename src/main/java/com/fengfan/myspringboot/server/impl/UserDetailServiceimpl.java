package com.fengfan.myspringboot.server.impl;

import com.fengfan.myspringboot.dao.UserDetailMapper;
import com.fengfan.myspringboot.pojo.UserDetail;
import com.fengfan.myspringboot.server.UserDetailService;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Resource;
import java.util.List;
@Log4j2
public class UserDetailServiceimpl implements UserDetailService {
    @Resource
    private UserDetailMapper userDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDetailMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insert(UserDetail record) {
        return userDetailMapper.insert(record);
    }


    @Override
    public int insertSelective(UserDetail record) {
        return userDetailMapper.insertSelective(record);
    }


    @Override
    public UserDetail selectByPrimaryKey(Integer id) {
        return userDetailMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(UserDetail record) {
        return userDetailMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateByPrimaryKey(UserDetail record) {
        return userDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserDetail> selectAll() {
        return userDetailMapper.selectAll();
    }

    @Override
    public UserDetail selectByUserDetail(UserDetail user) {
        return userDetailMapper.selectByUserDetail(user);
    }
}
