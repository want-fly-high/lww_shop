package com.cmpay.lww.dto;

import com.cmpay.lww.bo.MenuInfoBO;
import lombok.Data;

import java.util.List;

/**
 *菜单信息数据传输对象
 */
@Data
public class MenuInfoDTO {
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
    /**
     * @Fields level 层级
     */
    private Integer level;

    /**
     * @Fields children 子节点
     */
    private List<MenuInfoBO> children;
}
