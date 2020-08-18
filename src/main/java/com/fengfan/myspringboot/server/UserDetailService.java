package com.fengfan.myspringboot.server;

import com.fengfan.myspringboot.pojo.UserDetail;

import java.util.List;


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
