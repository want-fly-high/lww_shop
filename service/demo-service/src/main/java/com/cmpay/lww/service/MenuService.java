package com.cmpay.lww.service;

import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.entity.MenuDO;

import java.util.List;

/**
 * 菜单服务类
 *
 * @author lww
 * @since 2020-06-21
 */
public interface MenuService {
    List<MenuDO> selectByCondition();

    //递归删除菜单
    void removeChildById(Long id);

    //获取全部菜单(递归 层级)
    List<MenuInfoBO> queryAllMenu();

}
