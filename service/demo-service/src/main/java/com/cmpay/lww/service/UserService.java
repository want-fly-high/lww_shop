package com.cmpay.lww.service;

import com.cmpay.lww.bo.UserInsertBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.entity.UsersDO;

import java.util.List;

public interface UserService {
    //批量删除用户
    boolean deleteBatch(Long[] roleIds);

    //保存用户和角色关系BO
    boolean saveUserRoleRalation(UserRoleInsertBO userRoleInsertBO);

    //增加用户信息
    boolean saveUser(UserInsertBO insertBO);

    //修改用户信息
    boolean updateUser(UsersDO usersDO);
}
