package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lww.bo.UserInsertBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.dao.IUserRoleDao;
import com.cmpay.lww.dao.IUsersDao;
import com.cmpay.lww.entity.UserRoleDO;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private IUsersDao iUsersDao;
    @Resource
    private IUserRoleDao iUserRoleDao;
    @Override
    public boolean deleteBatch(Long[] userIds) {
        List<Long> idList = Arrays.asList(userIds);
        int flag = iUsersDao.deleteBatch(idList);
        return flag>0?true:false;
    }

    /***
     * 增加用户角色关系
     * @param userRoleInsertBO
     * @return
     */
    @Override
    public boolean saveUserRoleRalation(UserRoleInsertBO userRoleInsertBO) {
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setRoleId(userRoleInsertBO.getRoleId());
        userRoleDO.setUserId(userRoleInsertBO.getUserId());
        userRoleDO.setId(new Random().nextLong());
        userRoleDO.setCreateDate(LocalDateTime.now());
        userRoleDO.setUpdateDate(LocalDateTime.now());
        userRoleDO.setIsUse(0);
        int insert = iUserRoleDao.insert(userRoleDO);
        return insert>0?true:false;
    }

    @Override
    public boolean saveUser(UserInsertBO insertBO) {
        UsersDO usersDO = new UsersDO();
        BeanUtils.copy(usersDO,insertBO);
        usersDO.setId(new Random().nextLong());
        usersDO.setCreateDate(LocalDateTime.now());
        usersDO.setUpdateDate(LocalDateTime.now());
        usersDO.setIsUse(0);
        int insert = iUsersDao.insert(usersDO);
        return insert>0?true:false;
    }

    @Override
    public boolean updateUser(UsersDO usersDO) {
        usersDO.setUpdateDate(LocalDateTime.now());
        int update = iUsersDao.updateById(usersDO);
        return update>0?true:false;
    }

}
