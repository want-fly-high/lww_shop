package com.cmpay.lww.service;

import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.bo.RoleMenuInsertBO;
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

    //为角色添加权限(批量)
    void saveRoleMenuRalation(RoleMenuInsertBO insertBO);

    //插入菜单
    void saveMenu(MenuInfoBO menuInfoBO);

    //修改菜单 根据id
    void updateMenu(MenuInfoBO menuInfoBO);

    //根据id获取菜单
    MenuInfoBO getRoleInfoById(MenuInfoBO menuInfoBO);

    //根据角色id获取菜单
    List<MenuInfoBO> getMenuInfoByRoleId(Long roleId);

}
