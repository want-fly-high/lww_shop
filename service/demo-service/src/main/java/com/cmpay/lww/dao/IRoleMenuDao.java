/*
 * @ClassName IRoleMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.RoleMenuDO;
import com.cmpay.lww.entity.RoleMenuDOKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoleMenuDao extends BaseDao<RoleMenuDO, Long> {
    //根据list进行批量插入
    void batchInsert(List<RoleMenuDO> list);
}