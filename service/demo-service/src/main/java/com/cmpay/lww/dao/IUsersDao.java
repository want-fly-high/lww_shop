/*
 * @ClassName IUsersDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 08:58:38
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.entity.UsersDOKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUsersDao extends BaseDao<UsersDO, UsersDOKey> {
    int updateById(UsersDO usersDO);

    int deleteBatch(List<Long> list);
}