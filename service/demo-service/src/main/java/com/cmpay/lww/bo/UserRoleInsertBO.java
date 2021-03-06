package com.cmpay.lww.bo;

import lombok.Data;

import java.util.List;

/**
 * 保存用户和角色关系的BO
 */
@Data
public class UserRoleInsertBO {
    //用户id
    private Long userId;

    //角色Id
    private List<Long> roleId;


}
