package com.cmpay.lww.dto;

import lombok.Data;

/**
 * 根据id获取菜单信息的DTO
 */
@Data
public class MenuInfoGetDTO {
    /**
     * @Fields id 权限id
     */
    private Long id;
    /**
     * @Fields pid 所属上级
     */
    private Long pid;
    /**
     * @Fields menuName 菜单名称
     */
    private String menuName;
    /**
     * @Fields type 菜单类型(1:菜单,2:按钮)
     */
    private Integer type;

}
