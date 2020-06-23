package com.cmpay.lww.controller;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.bo.RoleMenuInsertBO;
import com.cmpay.lww.dto.MenuAddReqDTO;
import com.cmpay.lww.dto.MenuUpdateReqDTO;
import com.cmpay.lww.dto.RoleMenuAddDTO;
import com.cmpay.lww.entity.MenuDO;
import com.cmpay.lww.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
     * 递归删除菜单
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public DefaultRspDTO<NoBody> deleteMenuById(@PathVariable Long id){
        menuService.removeChildById(id);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 递归获取所有菜单
     * @return
     */
    @GetMapping("/testGetAll")
    public List<MenuInfoBO> testGetAll(){
        return menuService.queryAllMenu();
    }

    /**
     * 为角色分配权限
     * @param menuAddDTO
     */
    @PostMapping("/testSaveRoleMenu")
    public DefaultRspDTO<NoBody> testSaveRoleMenu(@RequestBody RoleMenuAddDTO menuAddDTO){
        RoleMenuInsertBO roleMenuInsertBO = new RoleMenuInsertBO();
        BeanUtils.copyProperties(roleMenuInsertBO, menuAddDTO);
        menuService.saveRoleMenuRalation(roleMenuInsertBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 插入菜单信息
     * @param menuAddReqDTO
     */
    @PostMapping("/testInsertMenu")
    public DefaultRspDTO<NoBody> testInsertMenu(@RequestBody MenuAddReqDTO menuAddReqDTO){
        MenuInfoBO menuInfoBO = new MenuInfoBO();
        BeanUtils.copyProperties(menuInfoBO, menuAddReqDTO);
        menuService.saveMenu(menuInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 更新菜单信息
     * @param menuUpdateReqDTO
     */
    @PostMapping("/tesUpdateMenu")
    public DefaultRspDTO<NoBody> tesUpdateMenu(@RequestBody MenuUpdateReqDTO menuUpdateReqDTO){
        MenuInfoBO menuInfoBO = new MenuInfoBO();
        BeanUtils.copyProperties(menuInfoBO, menuUpdateReqDTO);
        menuService.updateMenu(menuInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
     * 根据角色获取菜单
     */
}
