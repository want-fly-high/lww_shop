/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoleDao extends BaseDao<RoleDO, Long> {
    /**
     * 根据id更新角色
     * @param roleDO
     * @return
     */
    int updateById(RoleDO roleDO);

    /**
     * 根据列表批量删除角色
     * @param list
     * @return
     */
    int deleteBatch(List<Long> list);

    /**
     * 根据id得到角色信息
     * @param roleId
     * @return
     */
    RoleDO selectById(Long roleId);

    /**
     * 根据角色id列表查询角色
     * @param list
     * @return
     */
    List<RoleDO> selectByIdList(List<Long> list);
}