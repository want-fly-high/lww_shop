/*
 * @ClassName IUsersDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 18:17:42
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.UsersDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUsersDao extends BaseDao<UsersDO, Long> {
    /**
     * 批量删除用户
     * @param idList
     * @return
     */
    int deleteBatch(List<Long> idList);

    /**
     * 根据id更新用户
     * @param usersDO
     * @return
     */
    int updateById(UsersDO usersDO);

    /**
     * 根据id得到用户信息
     * @param id
     * @return
     */
    UsersDO selectById(Long id);
}