package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.bo.RoleInfoQueryBO;
import com.cmpay.lww.bo.RoleInsertBO;
import com.cmpay.lww.bo.UserInfoBO;
import com.cmpay.lww.dao.IRoleDao;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.enums.MsgEnum;
import com.cmpay.lww.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * 角色服务实现类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private IRoleDao roleDao;

    /**
     * 进行批量删除根据id的数组
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
            List<Long> idList = Arrays.asList(roleIds);
            int flag = roleDao.deleteBatch(idList);
            if(flag <= 0){
                BusinessException.throwBusinessException(MsgEnum.DB_DELETE_FAILED);
            }
    }

    /**
     * 保存角色信息
     * @param roleInsertBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveRole(RoleInsertBO roleInsertBO) {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copy(roleDO, roleInsertBO);
        roleDO.setCreateDate(LocalDateTime.now());
        roleDO.setUpdateDate(LocalDateTime.now());
        roleDO.setIsUse(0);
        roleDO.setId(new Random().nextLong());
        int insert = roleDao.insert(roleDO);
        if (insert != 1){
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }
    }

    /**
     * 更新角色信息
     * @param roleInfoBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateRole(RoleInfoBO roleInfoBO) {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(roleDO, roleInfoBO);
        roleDO.setUpdateDate(LocalDateTime.now());
        int update = roleDao.updateById(roleDO);
        if (update != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    /**
     * 查询所有角色信息
     * @param queryBO
     * @return
     */
    @Override
    public PageInfo<RoleDO> selectAllRole(RoleInfoQueryBO queryBO) {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(roleDO, queryBO);
        return PageUtils.pageQueryWithCount(queryBO.getPageNum(),queryBO.getPageSize(),()->roleDao.find(roleDO));
    }


    /**
     * 根据id获取角色信息
     * @param roleInfoBO
     * @return
     */
    @Override
    public RoleInfoBO getRoleInfoById(RoleInfoBO roleInfoBO) {
        RoleDO roleDO = roleDao.selectById(roleInfoBO.getId());
        BeanUtils.copyProperties(roleInfoBO, roleDO);
        return roleInfoBO;
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteById(Long id) {
        RoleDO roleDO = new RoleDO();
        roleDO.setId(id);
        roleDO.setIsUse(1);
        int res = roleDao.updateById(roleDO);
        if ( res != 1){
            BusinessException.throwBusinessException(MsgEnum.DB_DELETE_FAILED);
        }
    }


}
