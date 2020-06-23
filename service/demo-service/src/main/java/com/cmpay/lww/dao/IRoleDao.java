/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.RoleDOKey;
import com.cmpay.lww.entity.UsersDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoleDao extends BaseDao<RoleDO, RoleDOKey> {
    int updateById(RoleDO roleDO);

    int deleteBatch(List<Long> list);

    RoleDO selectById(Long roleId);
}