package com.cmpay.lww.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoBO {
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
}
