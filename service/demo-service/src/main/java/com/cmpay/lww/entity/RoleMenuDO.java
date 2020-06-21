/*
 * @ClassName RoleMenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-20 21:24:43
 */
package com.cmpay.lww.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class RoleMenuDO extends BaseDO {
    @Override
    public String toString() {
        return "RoleMenuDO{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                ", isUse=" + isUse +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    /**
     * @Fields id 菜单角色id
     */
    private Long id;
    /**
     * @Fields roleId 角色id
     */
    private Long roleId;
    /**
     * @Fields menuId 角色id
     */
    private Long menuId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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