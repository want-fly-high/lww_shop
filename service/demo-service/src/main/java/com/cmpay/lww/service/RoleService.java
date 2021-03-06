package com.cmpay.lww.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lww.bo.*;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.UsersDO;

import javax.management.relation.Role;
import java.util.List;

/**
 * 角色服务类
 */
public interface RoleService {
    /**
     * 批量删除
     * @param userIds
     */
    void deleteBatch(Long[] userIds);

    /**
     * 增加用户信息
     * @param roleInsertBO
     */
    void saveRole(RoleInsertBO roleInsertBO);

    /**
     *修改角色信息
     * @param roleInfoBO
     */
    void updateRole(RoleInfoBO roleInfoBO);

    /**
     * 分页查询角色信息
     * @param queryBO
     * @return
     */
    PageInfo<RoleDO> selectAllRole(RoleInfoQueryBO queryBO);

    /**
     * 根据id查询角色信息
     * @param roleInfoBO
     * @return
     */
    RoleInfoBO getRoleInfoById(RoleInfoBO roleInfoBO);

    /**
     * 根据id删除角色
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据用户ID获取角色信息
     * @param userId
     * @return
     */
    List<RoleInfoBO> getRoleInfoByUserId(Long userId);
}
