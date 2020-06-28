package com.cmpay.lww.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRoleAddReqDTO {
    //用户id
    private Long userId;

    //角色Id
    private List<Long> roleId;

}
