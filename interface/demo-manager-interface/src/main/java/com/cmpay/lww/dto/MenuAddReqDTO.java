package com.cmpay.lww.dto;

import lombok.Data;

/**
 * 增加菜单请求数据转换对象
 */
@Data
public class MenuAddReqDTO {
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

}
