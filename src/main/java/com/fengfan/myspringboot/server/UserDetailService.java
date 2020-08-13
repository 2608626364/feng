package com.fengfan.myspringboot.server;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.fengfan.myspringboot.mapper.UserDetailMapper;
import com.fengfan.myspringboot.pojo.UserDetail;

import java.util.List;

@Service
public class UserDetailService {

    @Resource
    private UserDetailMapper userDetailMapper;


    public int deleteByPrimaryKey(Integer id) {
        return userDetailMapper.deleteByPrimaryKey(id);
    }


    public int insert(UserDetail record) {
        return userDetailMapper.insert(record);
    }


    public int insertSelective(UserDetail record) {
        return userDetailMapper.insertSelective(record);
    }


    public UserDetail selectByPrimaryKey(Integer id) {
        return userDetailMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(UserDetail record) {
        return userDetailMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(UserDetail record) {
        return userDetailMapper.updateByPrimaryKey(record);
    }

    public List<UserDetail> selectAll(Integer id) {
        return userDetailMapper.selectAll();
    }

    public UserDetail selectByUserDetail(UserDetail user) {
        return userDetailMapper.selectByUserDetail(user);
    }
}
