package com.cmpay.lww.controller;

import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.bo.RoleMenuInsertBO;
import com.cmpay.lww.entity.MenuDO;
import com.cmpay.lww.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @GetMapping("/test")
    public List<MenuDO> test(){
        menuService.removeChildById(1L);
        return null;
    }

    @GetMapping("/testGetAll")
    public List<MenuInfoBO> testGetAll(){
        return menuService.queryAllMenu();
    }

    @PostMapping("/testSaveRoleMenu")
    public void testSaveRoleMenu(@RequestBody RoleMenuInsertBO roleMenuInsertBO){
        menuService.saveRoleMenuRalation(roleMenuInsertBO);
    }

    @PostMapping("/testInsertMenu")
    public void testInsertMenu(@RequestBody MenuDO menuDO){
        menuService.saveMenu(menuDO);
    }

    @PostMapping("/tesUpdateMenu")
    public void tesUpdateMenu(@RequestBody MenuDO menuDO){
        menuService.updateMenu(menuDO);
    }
}
