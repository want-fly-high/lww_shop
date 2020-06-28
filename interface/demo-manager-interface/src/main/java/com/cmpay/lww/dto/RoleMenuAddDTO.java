package com.cmpay.lww.dto;

import lombok.Data;

@Data
public class RoleMenuAddDTO {
    //角色id
    private Long roleId;

    //权限id
    private Long[] menuId;
}
