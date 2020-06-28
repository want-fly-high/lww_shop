package com.cmpay.lww.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDTO {
    /**
     * @Fields id 用户id
     */
    private Long id;

    /**
     * @Fields username 用户名
     */
    private String username;
    /**
     * @Fields name 用户名字
     */
    private String name;

    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields status 用户状态0正常 2禁用
     */
    private Integer status;
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

}
