package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lww.bo.RoleInsertBO;
import com.cmpay.lww.dao.IRoleDao;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.service.RoleService;
import org.springframework.stereotype.Service;

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
    public boolean deleteBatch(Long[] roleIds) {
            List<Long> idList = Arrays.asList(roleIds);
            int flag = roleDao.deleteBatch(idList);
            return flag>0?true:false;
    }

    /**
     * 保存角色信息
     * @param roleInsertBO
     * @return
     */
    @Override
    public boolean saveRole(RoleInsertBO roleInsertBO) {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copy(roleDO, roleInsertBO);
        roleDO.setCreateDate(LocalDateTime.now());
        roleDO.setUpdateDate(LocalDateTime.now());
        roleDO.setIsUse(0);
        roleDO.setId(new Random().nextLong());
        int insert = roleDao.insert(roleDO);
        return insert>0?true:false;
    }

    /**
     * 更新角色信息
     * @param roleDO
     * @return
     */
    @Override
    public boolean updateRole(RoleDO roleDO) {
        roleDO.setUpdateDate(LocalDateTime.now());
        int update = roleDao.updateById(roleDO);
        return update>0?true:false;
    }
}
