package com.cmpay.lww.dto;

import lombok.Data;

@Data
public class RoleDelDTO {
    /**
     *  要删除的id列表
     */
    private Long[] roleIds;
}
