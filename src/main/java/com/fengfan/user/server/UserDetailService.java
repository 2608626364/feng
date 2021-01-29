package com.fengfan.user.server;

import com.fengfan.user.pojo.UserDetail;

public interface UserDetailService {


    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);

    /**
     * 根据user对象查找
     *
     * @param user primary user
     * @return object by primary key
     */
    UserDetail selectByPrimaryKeySelective(UserDetail user);

    /**
     * 根据用户名查找
     *
     * @param userName
     * @return object by primary key
     */
    UserDetail selectByUserName(String userName);

    /**
     * 校验非空字段
     *
     * @param user
     * @return
     */
    boolean checkUser(UserDetail user);
}
