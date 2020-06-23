package com.cmpay.lww.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lww.bo.UserInfoBO;
import com.cmpay.lww.bo.UserInfoQueryBO;
import com.cmpay.lww.bo.UserInsertBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.entity.UsersDO;

import java.util.List;

public interface UserService {
    //批量删除用户
    void deleteBatch(Long[] roleIds);

    //保存用户和角色关系BO
    boolean saveUserRoleRalation(UserRoleInsertBO userRoleInsertBO);

    //增加用户信息
    void saveUser(UserInfoBO userInfoBO);

    //修改用户信息
    void updateUser(UserInfoBO userInfoBO);

    //分页查询用户信息
    PageInfo<UsersDO> selectAllUser(UserInfoQueryBO queryBO);

    //查询用户信息
    UserInfoBO getUserInfo(UserInfoBO userInfoBO);

    //根据id删除用户信息
    void delete(Long userId);
}
