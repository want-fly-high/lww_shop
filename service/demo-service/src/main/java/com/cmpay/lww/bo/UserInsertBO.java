package com.cmpay.lww.bo;

import lombok.Data;

/**
 * 插入信息业务对象
 */
@Data
public class UserInsertBO {
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
