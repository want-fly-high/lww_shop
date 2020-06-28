package com.cmpay.lww.service;

import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.bo.RoleInfoBO;
import com.cmpay.lww.bo.RoleMenuInsertBO;
import com.cmpay.lww.dto.MenuInfoDTO;
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

    /**
     * 递归删除菜单
     * @param id
     */
    void removeChildById(Long id);

    /**
     * 获取全部菜单(递归 层级)
     * @return
     */
    List<MenuInfoDTO> queryAllMenu();

    /**
     * 为角色添加权限(批量)
     * @param insertBO
     */
    void saveRoleMenuRalation(RoleMenuInsertBO insertBO);

    /**
     * 插入菜单
     * @param menuInfoBO
     */
    void saveMenu(MenuInfoBO menuInfoBO);

    /**
     * 修改菜单 根据id
     * @param menuInfoBO
     */
    void updateMenu(MenuInfoBO menuInfoBO);

    /**
     * 根据id获取菜单
     * @param menuInfoBO
     * @return
     */
    MenuInfoBO getRoleInfoById(MenuInfoBO menuInfoBO);

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    List<MenuInfoDTO> getMenuInfoByRoleId(Long roleId);

}
