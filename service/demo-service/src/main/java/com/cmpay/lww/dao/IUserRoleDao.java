/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, Long> {
   /**
    * 批量插入用户角色表
    * @param list
    * @return
    */
   int batchInsert(List<UserRoleDO> list);
}