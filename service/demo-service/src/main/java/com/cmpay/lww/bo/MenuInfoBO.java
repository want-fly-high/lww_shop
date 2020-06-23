package com.cmpay.lww.bo;

import com.cmpay.lww.entity.MenuDO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/***
 * 返回业务层的信息 多了孩子节点child以及层级level
 */
@Data
public class MenuInfoBO {
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
    /**
     * @Fields isUse 是否逻辑删除 0未删除,1已删除
     */
    private Integer isUse;
    /**
     * @Fields createDate 创建时间
     */
    private boolean selected;

    private LocalDateTime createDate;
    /**
     * @Fields updateDate 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * @Fields level 层级
     */
    private Integer level;

    /**
     * @Fields children 子节点
     */
    private List<MenuInfoBO> children;

}
