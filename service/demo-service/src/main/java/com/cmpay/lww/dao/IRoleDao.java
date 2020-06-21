/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.RoleDOKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleDao extends BaseDao<RoleDO, RoleDOKey> {
}