package com.cmpay.lww.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色查询BO
 */
@Data
public class RoleInfoQueryBO {
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNum;
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
     * @Fields isUse 是否被删除,0未删除 1已删除
     */
    private Integer isUse;
    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * @Fields updateDate 修改时间
     */
    private LocalDateTime updateDate;

}
