package com.cmpay.lww.dto;

import lombok.Data;

/**
 * 菜单更新请求数据传输对象
 */
@Data
public class MenuUpdateReqDTO {
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
     * @Fields munuValue 权限值
     */
    private String munuValue;
    /**
     * @Fields path 访问路径
     */
    private String path;
    /**
     * @Fields redirect 路由重定向地址别名
     */
    private String redirect;
    /**
     * @Fields status 状态(0:禁止,1:正常)
     */
    private Integer status;

}
