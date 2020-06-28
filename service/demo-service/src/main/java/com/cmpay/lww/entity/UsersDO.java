/*
 * @ClassName UsersDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 18:17:42
 */
package com.cmpay.lww.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class UsersDO extends BaseDO {
    /**
     * @Fields id 用户id
     */
    private Long id;
    /**
     * @Fields uid 用户唯一表示
     */
    private String uid;
    /**
     * @Fields username 用户名
     */
    private String username;
    /**
     * @Fields password 密码
     */
    private String password;
    /**
     * @Fields name 用户名字
     */
    private String name;
    /**
     * @Fields phone 手机号码
     */
    private String phone;
    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * @Fields createBy 创建人
     */
    private Long createBy;
    /**
     * @Fields updateDate 更新时间
     */
    private LocalDateTime updateDate;
    /**
     * @Fields updateBy 更新人
     */
    private Long updateBy;
    /**
     * @Fields status 用户状态0正常 2禁用
     */
    private Integer status;
    /**
     * @Fields isUse 是否已进行删除，0未删除 1已删除
     */
    private Integer isUse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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
}