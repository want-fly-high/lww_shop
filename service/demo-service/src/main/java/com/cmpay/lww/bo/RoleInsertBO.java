package com.cmpay.lww.bo;

import lombok.Data;

@Data
public class RoleInsertBO {
    private String roleName;
    /**
     * @Fields roleCode 角色编码
     */
    private String roleCode;
    /**
     * @Fields remark 备注
     */
    private String remark;
}
