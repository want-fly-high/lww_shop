package com.cmpay.lww.controller;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.bo.RoleInfoQueryBO;
import com.cmpay.lww.bo.RoleInsertBO;
import com.cmpay.lww.dto.*;
import com.cmpay.lww.entity.RoleDO;
import com.cmpay.lww.enums.MsgEnum;
import com.cmpay.lww.service.RoleService;
import com.cmpay.lww.utils.BeanConvertUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * 批量删除角色
     * @param roleDelDTO
     * @return
     */
    @DeleteMapping("/deleteRoleBatch")
    public DefaultRspDTO<NoBody> testDeleteBatch(@RequestBody RoleDelDTO roleDelDTO){
        roleService.deleteBatch(roleDelDTO.getRoleIds());
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 保存角色信息
     * @param roleInsertBO
     */
    @PostMapping("/testSaveRole")
    public void testSaveUser(@RequestBody RoleInsertBO roleInsertBO){
        roleService.saveRole(roleInsertBO);
    }

    /**
     * 根据id修改角色
     * @param updateDTO
     * @return
     */
    @PostMapping("/testUpdateRole")
    public DefaultRspDTO<NoBody> testUpdateUser(@RequestBody RoleUpdateReqDTO updateDTO){
        RoleInfoBO roleInfoBO = new RoleInfoBO();
        BeanUtils.copyProperties(roleInfoBO, updateDTO);
        roleService.updateRole(roleInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 分页列出所有数据
     * @param roleInfoQueryReqDTO
     * @return
     */
    @GetMapping("/list")
    public RoleInfoQueryRspDTO getRoleInfoPage(@QueryBody RoleInfoQueryReqDTO roleInfoQueryReqDTO){
        RoleInfoQueryBO roleInfoQueryBO = new RoleInfoQueryBO();
        BeanUtils.copyProperties(roleInfoQueryBO,roleInfoQueryReqDTO);
        PageInfo<RoleDO> page = roleService.selectAllRole(roleInfoQueryBO);
        List<RoleInfoDTO> roleInfoDTOS = BeanConvertUtils.convertList(page.getList(), RoleInfoDTO.class);
        RoleInfoQueryRspDTO roleInfoQueryRspDTO = new RoleInfoQueryRspDTO();
        roleInfoQueryRspDTO.setList(roleInfoDTOS);
        roleInfoQueryRspDTO.setPageNum(page.getPageNum());
        roleInfoQueryRspDTO.setPages(page.getPages());
        roleInfoQueryRspDTO.setPageSize(page.getSize());
        roleInfoQueryRspDTO.setTotal(page.getTotal());
        roleInfoQueryRspDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        roleInfoQueryRspDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
        return roleInfoQueryRspDTO;
    }

    /**
     * 根据id列出角色信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public DefaultRspDTO<RoleInfoDTO> getRoleInfoById(@PathVariable Long id){
        RoleInfoBO roleInfoBO = new RoleInfoBO();
        roleInfoBO.setId(id);
        RoleInfoBO roleInfo = roleService.getRoleInfoById(roleInfoBO);
        RoleInfoDTO roleInfoDTO = new RoleInfoDTO();
        BeanUtils.copyProperties(roleInfoDTO, roleInfo);
        return DefaultRspDTO.newSuccessInstance(roleInfoDTO);
    }

    /**
     * 根据id删除角色
     * @param id 角色id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public DefaultRspDTO<NoBody> deleteByRoleId(@PathVariable Long id){
        roleService.deleteById(id);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    @GetMapping("/info/getByUserId/{userId}")
    public List<RoleInfoDTO> getByUserId(@PathVariable Long userId){
        List<RoleInfoBO> roleInfoByUserId = roleService.getRoleInfoByUserId(userId);
        List<RoleInfoDTO> roleInfoDTOS = BeanConvertUtils.convertList(roleInfoByUserId, RoleInfoDTO.class);
        return roleInfoDTOS;
    }

}
