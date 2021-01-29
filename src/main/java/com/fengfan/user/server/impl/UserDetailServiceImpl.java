package com.fengfan.user.server.impl;

import com.fengfan.user.server.UserDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.fengfan.user.pojo.UserDetail;
import com.fengfan.user.dao.UserDetailMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Resource
    private UserDetailMapper userDetailMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer id) {
        return userDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(UserDetail record) {
        return userDetailMapper.insert(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(UserDetail record) {
        return userDetailMapper.insertSelective(record);
    }

    @Override
    public UserDetail selectByPrimaryKey(Integer id) {
        return userDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(UserDetail record) {
        return userDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(UserDetail record) {
        return userDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetail selectByPrimaryKeySelective(UserDetail user) {
        return userDetailMapper.selectByPrimaryKeySelective(user);
    }

    /**
     * 根据用户名或手机号查找
     *
     * @param userName
     * @return object by primary key
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetail selectByUserName(String userName) {
        return userDetailMapper.selectByUserName(userName);
    }

    @Override
    public boolean checkUser(UserDetail user) {
        if (StringUtils.isBlank(user.getUserName())) {
            return false;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return false;
        }
        if (StringUtils.isBlank(user.getPhoneNumber())) {
            return false;
        }
        if (StringUtils.isBlank(user.getUserNickname())) {
            return false;
        }
        return true;
    }
}
