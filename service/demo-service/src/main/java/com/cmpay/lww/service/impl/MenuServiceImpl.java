package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.dao.IMenuDao;
import com.cmpay.lww.entity.MenuDO;
import com.cmpay.lww.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  菜单 服务shi
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private IMenuDao iMenuDao;
    @Override
    public List<MenuDO> selectByCondition() {
        return iMenuDao.selectByCondition();
    }
//===================递归删除所有===================
    @Override
    public void removeChildById(Long id) {
        //1.创建list集合，用于封装所有需要删除的菜单id值
        List<Long> idList = new ArrayList<>();
        //2 向idList集合设置删除菜单id
        this.selectMenuChildById(id,idList);
        //把当前id装进list
        idList.add(id);
        //根据List集合进行批量删除
        iMenuDao.deleteBatch(idList);
    }

    //2.根据当前菜单id，查询菜单中的子菜单，装入list
    private void selectMenuChildById(Long id, List<Long> idList) {
        MenuDO menuDO = new MenuDO();
        menuDO.setPid(id);
        //查看菜单子菜单id
        List<MenuDO> childList = iMenuDao.find(menuDO);
        childList.stream().forEach(item->{
            //装入到idList里面
            idList.add(item.getId());
            //递归查询
            this.selectMenuChildById(item.getId(),idList);
        });
    }

//=================递归查询所有菜单=================

    /**
     * 获取所有菜单
     * @return
     */
    @Override
public List<MenuInfoBO> queryAllMenu(){
    //查询所有数据
    List<MenuDO> menuList = iMenuDao.find(null);
    //把查询到的DO转换为BO
    List<MenuInfoBO> menuInfoList = new ArrayList<>();
    for (MenuDO menuDO : menuList){
        MenuInfoBO menuInfoBO = new MenuInfoBO();
        BeanUtils.copy(menuInfoBO,menuDO);
        menuInfoList.add(menuInfoBO);
    }
    //把查询到的菜单list按照树形结构进行封装
    List<MenuInfoBO> resultList = buildMenu(menuInfoList);
    return resultList;
}

    /**
     * //把返回所有菜单list集合进行封装的方法
     * @param menuList
     * @return
     */
    private List<MenuInfoBO> buildMenu(List<MenuInfoBO> menuList) {
        //最终返回的list集合
        List<MenuInfoBO> finalNode = new ArrayList<>();
        for (MenuInfoBO menuInfoNode : menuList){
            //得到顶层pid=0的递归入口
            if(menuInfoNode.getPid().equals(0L)){
                //顶层等级为1
                menuInfoNode.setLevel(1);
                //根据顶层，逐渐向下查询其子菜单，封装到finalNode
                finalNode.add(selectChildren(menuInfoNode,menuList));
            }
        }
        return finalNode;
    }

    /**
     * 查询子菜单
     * @param menuInfoNode
     * @param menuList
     * @return
     */
    private MenuInfoBO selectChildren(MenuInfoBO menuInfoNode, List<MenuInfoBO> menuList) {
        //因为向一层里面放二层，二层放三层，把对象初始话  防止出现空指针异常
        menuInfoNode.setChildren(new ArrayList<>());
        for(MenuInfoBO it : menuList){
            //判断id和pid是否相等
            if(menuInfoNode.getId().equals(it.getPid())){
                //如果相等 子菜单等级等于父菜单等级+1
                int level = menuInfoNode.getLevel()+1;
                it.setLevel(level);
                //所有children为空，进行初始话操作
                if(menuInfoNode.getChildren() == null){
                    menuInfoNode.setChildren(new ArrayList<MenuInfoBO>());
                }
                //把查询出来的子菜单放到父菜单中
                menuInfoNode.getChildren().add(selectChildren(it,menuList));
            }
        }
        return menuInfoNode;
    }
}
