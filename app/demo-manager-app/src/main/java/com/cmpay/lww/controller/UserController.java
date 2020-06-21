package com.cmpay.lww.controller;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lww.bo.UserInsertBO;
import com.cmpay.lww.bo.UserRoleInsertBO;
import com.cmpay.lww.dto.UserDelDTO;
import com.cmpay.lww.dto.UserUpdateDTO;
import com.cmpay.lww.entity.UsersDO;
import com.cmpay.lww.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/testSaveUserRole")
    public void testSaveUserRole(@RequestBody UserRoleInsertBO insertBO){
        userService.saveUserRoleRalation(insertBO);
    }
    //DeleteMap？
    @PostMapping("/testDeleteBatch")
    public void testDeleteBatch(@RequestBody UserDelDTO userDelDTO){
        System.out.println(Arrays.toString(userDelDTO.getRolesIds()));
        userService.deleteBatch(userDelDTO.getRolesIds());
    }

    //增加用户
    @PostMapping("/testSaveUser")
    public void testSaveUser(@RequestBody UserInsertBO userInsertBO){
        userService.saveUser(userInsertBO);
    }

    //修改用户通过id
    @PostMapping("/testUpdateUser")
    public void testUpdateUser(@RequestBody UserUpdateDTO updateDTO){
        UsersDO usersDO = new UsersDO();
        BeanUtils.copy(usersDO, updateDTO);
        userService.updateUser(usersDO);
    }
}
