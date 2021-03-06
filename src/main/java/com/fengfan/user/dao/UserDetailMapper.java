package com.fengfan.user.dao;

import com.fengfan.user.pojo.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDetailMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserDetail record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserDetail record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserDetail selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserDetail record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserDetail record);

    /**
     * 根据user对象查找
     * @param user primary user
     * @return object by primary key
     */
    UserDetail selectByPrimaryKeySelective(UserDetail user);

    /**
     * 根据用户名查找
     * @param userName or phone
     * @return object by primary key
     */
    UserDetail selectByUserName( @Param("userName") String userName );
}