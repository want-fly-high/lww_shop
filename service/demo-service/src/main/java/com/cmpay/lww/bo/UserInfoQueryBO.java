package com.cmpay.lww.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 查询用户BO
 */
@Data
public class UserInfoQueryBO {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;

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
}
