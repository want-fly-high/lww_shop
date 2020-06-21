/*
 * @ClassName RoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class RoleDO extends BaseDO {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}