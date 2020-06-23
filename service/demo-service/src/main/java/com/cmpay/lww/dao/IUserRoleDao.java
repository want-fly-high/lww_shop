/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.UserRoleDO;
import com.cmpay.lww.entity.UserRoleDOKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, UserRoleDOKey> {

   int batchInsert(List<UserRoleDO> list);
}