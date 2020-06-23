package com.cmpay.lww.dto;

import lombok.Data;

@Data
public class UserUpdateReqDTO {
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
}
