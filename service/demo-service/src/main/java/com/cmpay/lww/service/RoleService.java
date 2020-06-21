package com.cmpay.lww.service;

import com.cmpay.lww.bo.RoleInsertBO;
import com.cmpay.lww.bo.UserInsertBO;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.UsersDO;

/**
 * 角色服务类
 */
public interface RoleService {
    //批量删除
    boolean deleteBatch(Long[] userIds);

    //增加用户信息
    boolean saveRole(RoleInsertBO roleInsertBO);

    //修改角色信息
    boolean updateRole(RoleDO roleDO);
}
