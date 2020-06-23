package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.lww.bo.*;
import com.cmpay.lww.dao.IUserRoleDao;
import com.cmpay.lww.dao.IUsersDao;
import com.cmpay.lww.entity.UserRoleDO;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.enums.MsgEnum;
import com.cmpay.lww.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    /**
     * 根据用户id数组批量删除用户
     * @param userIds
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteBatch(Long[] userIds) {
        List<Long> idList = Arrays.asList(userIds);
        int flag = iUsersDao.deleteBatch(idList);
        if (flag<=0){
            BusinessException.throwBusinessException(MsgEnum.DB_DELETE_FAILED);
        }
    }

    /***
     * 增加用户角色关系
     * @param userRoleInsertBO
     * @return
     */
    @Override
    public void saveUserRoleRalation(UserRoleInsertBO userRoleInsertBO) {
        List<UserRoleDO> list = new ArrayList<>();
        for (int i=0; i<userRoleInsertBO.getRoleId().size(); i++){
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setUserId(userRoleInsertBO.getUserId());
            userRoleDO.setRoleId(userRoleInsertBO.getRoleId().get(i));
            userRoleDO.setId(new Random().nextLong());
            userRoleDO.setCreateDate(LocalDateTime.now());
            userRoleDO.setUpdateDate(LocalDateTime.now());
            userRoleDO.setIsUse(0);
            list.add(userRoleDO);
        }

        int res = iUserRoleDao.batchInsert(list);
        if (res <= 1){
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }
    }

    /**
     * 保存用户信息方法
     * @param userInfoBO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUser(UserInfoBO userInfoBO) {
        UsersDO usersDO = new UsersDO();
        BeanUtils.copy(usersDO,userInfoBO);
        usersDO.setId(new Random().nextLong());
        usersDO.setCreateDate(LocalDateTime.now());
        usersDO.setUpdateDate(LocalDateTime.now());
        usersDO.setIsUse(0);
        int insert = iUsersDao.insert(usersDO);
        if (insert != 1){
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }

    /**
     * 根据id更新用户
     * @param userInfoBO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateUser(UserInfoBO userInfoBO) {
        //需要进行加密
        UsersDO usersDO = new UsersDO();
        BeanUtils.copyProperties(usersDO, userInfoBO);
        usersDO.setUpdateDate(LocalDateTime.now());
        int update = iUsersDao.updateById(usersDO);
        if(update != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    /**
     *分页查询用户
     */
    @Override
    public PageInfo<UsersDO> selectAllUser(UserInfoQueryBO queryBO) {
        UsersDO usersDO = new UsersDO();
        BeanUtils.copy(usersDO, queryBO);
        return PageUtils.pageQueryWithCount(queryBO.getPageNum(), queryBO.getPageSize(), ()->iUsersDao.find(usersDO));
    }

    /**
     * 根据id查询用户信息
     * @param userInfoBO
     * @return
     */
    @Override
    public UserInfoBO getUserInfo(UserInfoBO userInfoBO) {
        UsersDO usersDO = iUsersDao.selectById(userInfoBO.getId());
        BeanUtils.copyProperties(userInfoBO,usersDO);
        return userInfoBO;
    }

    /**
     * 根据id删除用户
     * @param userId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long userId) {
        UsersDO usersDO = new UsersDO();
        usersDO.setId(userId);
        usersDO.setIsUse(1);
        int res = iUsersDao.updateById(usersDO);
        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_DELETE_FAILED);
        }

    }

    /**
     * 用户登录
     * @param userInfoBO
     * @return
     */
    @Override
    public UserInfoBO login(UserInfoBO userInfoBO) {
        userInfoBO.setId(1L);
        userInfoBO.setUsername("aaaa");
        return userInfoBO;
    }



}
