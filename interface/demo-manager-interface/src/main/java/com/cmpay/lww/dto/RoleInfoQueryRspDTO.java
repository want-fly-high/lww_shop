package com.cmpay.lww.dto;

import lombok.Data;

import java.util.List;

/**
 * 角色查询返回DTO
 */
@Data
public class RoleInfoQueryRspDTO extends PageableRspDTO {
    private List<RoleInfoDTO> list;
}
