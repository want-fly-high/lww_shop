package com.cmpay.lww.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.bo.UserInfoBO;
import com.cmpay.lww.bo.UserInfoQueryBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.entity.UsersDO;

import java.util.List;


public interface UserService {
    /**
     * 批量删除用户
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);

    /**
     * 保存用户和角色关系BO
     * @param userRoleInsertBO
     */
    void saveUserRoleRalation(UserRoleInsertBO userRoleInsertBO);

    /**
     * 增加用户信息
     * @param userInfoBO
     */
    void saveUser(UserInfoBO userInfoBO);

    /**
     * 修改用户信息
     * @param userInfoBO
     */
    void updateUser(UserInfoBO userInfoBO);

    /**
     * 分页查询用户信息
     * @param queryBO
     * @return
     */
    PageInfo<UsersDO> selectAllUser(UserInfoQueryBO queryBO);

    /**
     * 查询用户信息
     * @param userInfoBO
     * @return
     */
    UserInfoBO getUserInfo(UserInfoBO userInfoBO);

    /**
     * 根据id删除用户信息
     * @param userId
     */
    void delete(Long userId);

    /**
     * 用户登录
     * @param userInfoBO
     * @return
     */
    UserInfoBO login(UserInfoBO userInfoBO);


}
