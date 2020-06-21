package com.cmpay.lww.bo;

import lombok.Data;

/**
 * 用于批量插入角色对应权限的BO
 */
@Data
public class RoleMenuInsertBO {
    //角色id
    private Long roleId;

    //权限id
    private Long[] menuId;
}
