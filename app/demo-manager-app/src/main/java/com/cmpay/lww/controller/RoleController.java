package com.cmpay.lww.controller;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lww.bo.RoleInsertBO;
import com.cmpay.lww.dto.RoleDelDTO;
import com.cmpay.lww.dto.RoleUpdateDTO;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    //DeleteMap？
    @PostMapping("/testDeleteRoleBatch")
    public void testDeleteBatch(@RequestBody RoleDelDTO roleDelDTO){
        System.out.println(Arrays.toString(roleDelDTO.getRoleIds()));
        roleService.deleteBatch(roleDelDTO.getRoleIds());
    }

    //增加角色
    @PostMapping("/testSaveRole")
    public void testSaveUser(@RequestBody RoleInsertBO roleInsertBO){
        roleService.saveRole(roleInsertBO);
    }

    //修改用户通过id
    @PostMapping("/testUpdateRole")
    public void testUpdateUser(@RequestBody RoleUpdateDTO updateDTO){
        RoleDO roleDO = new RoleDO();
        BeanUtils.copy(roleDO, updateDTO);
        roleService.updateRole(roleDO);
    }
}
