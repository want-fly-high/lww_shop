/*
 * @ClassName MenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:21:42
 */
package com.cmpay.lww.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class MenuDO extends BaseDO {
    /**
     * @Fields id 权限id
     */
    private Long id;
    /**
     * @Fields pid 所属上级
     */
    private Long pid;
    /**
     * @Fields menuName 菜单名称
     */
    private String menuName;
    /**
     * @Fields type 菜单类型(1:菜单,2:按钮)
     */
    private Integer type;
    /**
     * @Fields munuValue 权限值
     */
    private String munuValue;
    /**
     * @Fields path 访问路径
     */
    private String path;
    /**
     * @Fields redirect 路由重定向地址别名
     */
    private String redirect;
    /**
     * @Fields status 状态(0:禁止,1:正常)
     */
    private Integer status;
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
     * @Fields createBy 创建人
     */
    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMunuValue() {
        return munuValue;
    }

    public void setMunuValue(String munuValue) {
        this.munuValue = munuValue;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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