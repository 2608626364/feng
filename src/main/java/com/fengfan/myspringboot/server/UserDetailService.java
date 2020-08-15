package com.fengfan.myspringboot.server;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.fengfan.myspringboot.dao.UserDetailMapper;
import com.fengfan.myspringboot.pojo.UserDetail;

import java.util.List;

@Service
public interface UserDetailService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(UserDetail record);

    public int insertSelective(UserDetail record);

    public UserDetail selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(UserDetail record);

    public int updateByPrimaryKey(UserDetail record);

    public List<UserDetail> selectAll();

    public UserDetail selectByUserDetail(UserDetail user);

}
