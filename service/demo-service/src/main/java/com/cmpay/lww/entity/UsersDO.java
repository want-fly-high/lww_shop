/*
 * @ClassName UsersDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 08:58:38
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
     * @Fields username 用户名
     */
    private String username;
    /**
     * @Fields password 密码
     */
    private String password;
    /**
     * @Fields phone 手机号码
     */
    private String phone;
    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * @Fields updateDate 更新时间
     */
    private LocalDateTime updateDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }
}