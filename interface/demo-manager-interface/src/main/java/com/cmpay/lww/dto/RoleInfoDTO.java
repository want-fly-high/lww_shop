package com.cmpay.lww.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色信息DTO
 */
@Data
public class RoleInfoDTO {
    /**
     * @Fields id 角色id
     */
    private Long id;
    /**
     * @Fields roleName 角色名
     */
    private String roleName;
    /**
     * @Fields roleCode 角色编码
     */
    private String roleCode;
    /**
     * @Fields remark 备注
     */
    private String remark;

    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
}
