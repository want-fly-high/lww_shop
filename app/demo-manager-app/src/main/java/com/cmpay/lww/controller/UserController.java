package com.cmpay.lww.controller;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lww.bo.UserInfoBO;
import com.cmpay.lww.bo.UserInfoQueryBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.dto.*;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.enums.MsgEnum;
import com.cmpay.lww.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 为用户分配角色
     * @param userRoleAddReqDTO
     * @return
     */
    @PostMapping("/testSaveUserRole")
    public DefaultRspDTO<NoBody> testSaveUserRole(@RequestBody UserRoleAddReqDTO userRoleAddReqDTO){
        UserRoleInsertBO userRoleInsertBO = new UserRoleInsertBO();
        BeanUtils.copyProperties(userRoleInsertBO, userRoleAddReqDTO);
        userService.saveUserRoleRalation(userRoleInsertBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public DefaultRspDTO<NoBody> deleteById(@PathVariable Long id){
        userService.delete(id);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 根据id的数组对角色进行批量删除
     * @param userDelDTO
     * @return
     */
    @DeleteMapping("/testDeleteBatch")
    public DefaultRspDTO<NoBody> testDeleteBatch(@RequestBody UserDelDTO userDelDTO){
        System.out.println(Arrays.toString(userDelDTO.getRolesIds()));
        userService.deleteBatch(userDelDTO.getRolesIds());
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 增加用户
     * @param userAddReqDTO
     * @return
     */
    @PostMapping("/save")
    public DefaultRspDTO<NoBody> save(@RequestBody UserAddReqDTO userAddReqDTO){
        UserInfoBO userInfoBO = new UserInfoBO();
        BeanUtils.copyProperties(userInfoBO, userAddReqDTO);
        userService.saveUser(userInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 通过id修改用户
     * @param updateDTO
     * @return
     */
    @PostMapping("/testUpdateUser")
    public DefaultRspDTO<NoBody> testUpdateUser(@RequestBody UserUpdateReqDTO updateDTO){
        UserInfoBO userInfoBO = new UserInfoBO();
        BeanUtils.copy(userInfoBO, updateDTO);
        userService.updateUser(userInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 分页列出所有用户
     * @param userInfoQueryReqDTO
     * @return
     */
    @GetMapping("/list")
    public UserInfoQueryRspDTO getUserInfoPage(@QueryBody UserInfoQueryReqDTO userInfoQueryReqDTO){
        UserInfoQueryBO userInfoQueryBO = new UserInfoQueryBO();
        BeanUtils.copyProperties(userInfoQueryBO, userInfoQueryReqDTO);
        PageInfo<UsersDO> page = userService.selectAllUser(userInfoQueryBO);
        UserInfoQueryRspDTO userInfoQueryRspDTO = new UserInfoQueryRspDTO();
        List<UserInfoDTO> userInfoDTOS = new ArrayList<>();
        List<UsersDO> usersDOList = page.getList();
        usersDOList.stream().forEach(item->{
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            BeanUtils.copyProperties(userInfoDTO, item);
            userInfoDTOS.add(userInfoDTO);
        });
        //为返回的DTO配置分页信息
        userInfoQueryRspDTO.setList(userInfoDTOS);
        userInfoQueryRspDTO.setPageNum(page.getPageNum());
        userInfoQueryRspDTO.setPages(page.getPages());
        userInfoQueryRspDTO.setPageSize(page.getSize());
        userInfoQueryRspDTO.setTotal(page.getTotal());
        userInfoQueryRspDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        userInfoQueryRspDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
        return userInfoQueryRspDTO;
    }

    /**
     * 查询用户信息
     */
    @GetMapping("/info/{id}")
    public DefaultRspDTO<UserInfoDTO> getUserInfoById(@PathVariable Long id) {
        return getUserInfo(id);
    }

    /**
     * 根据id获取用户并将其封装进DefaultRspDTO的方法
     * @param id
     * @return
     */
    private DefaultRspDTO<UserInfoDTO> getUserInfo(Long id) {
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setId(id);
        UserInfoBO userInfo = userService.getUserInfo(userInfoBO);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        return DefaultRspDTO.newSuccessInstance(userInfoDTO);
    }

    @GetMapping("/testId}")
    public String  testId() {
        return IdGenUtils.generateId("LWW_ROLEMENU_ID");
    }

}