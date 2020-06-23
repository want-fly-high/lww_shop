package com.cmpay.lww.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lww.bo.*;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.UsersDO;

import javax.management.relation.Role;

/**
 * 角色服务类
 */
public interface RoleService {
    //批量删除
    void deleteBatch(Long[] userIds);

    //增加用户信息
    void saveRole(RoleInsertBO roleInsertBO);

    //修改角色信息
    void updateRole(RoleInfoBO roleInfoBO);

    //分页查询角色信息
    PageInfo<RoleDO> selectAllRole(RoleInfoQueryBO queryBO);

    //根据id查询角色信息
    RoleInfoBO getRoleInfoById(RoleInfoBO roleInfoBO);

    //根据id删除角色
    void deleteById(Long id);
}
