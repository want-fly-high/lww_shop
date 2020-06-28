/*
 * @ClassName UserRoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class UserRoleDO extends BaseDO {
    /**
     * @Fields id 菜单角色id
     */
    private Long id;
    /**
     * @Fields userId 用户id
     */
    private Long userId;
    /**
     * @Fields roleId 角色id
     */
    private Long roleId;
    /**
     * @Fields isUse 是否逻辑删除 0未删除,1已删除
     */
    private Integer isUse;
    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * @Fields updateDate 更新时间
     */
    private LocalDateTime updateDate;
    /**
     * @Fields createBy 创建人
     */
    private Long createBy;
    /**
     * @Fields updateBy更新人
     */
    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}