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
     * @Fields uid 用户唯一表示
     */
    private String uid;
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
}
