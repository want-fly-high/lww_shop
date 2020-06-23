package com.cmpay.lww.service.impl;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.cache.redis.RedisCacheable;
import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.bo.RoleMenuInsertBO;
import com.cmpay.lww.dao.IMenuDao;
import com.cmpay.lww.dao.IRoleMenuDao;
import com.cmpay.lww.entity.MenuDO;
import com.cmpay.lww.entity.RoleMenuDO;
import com.cmpay.lww.enums.MsgEnum;
import com.cmpay.lww.service.MenuService;
import com.cmpay.lww.utils.BeanConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  菜单 服务实现类
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private IMenuDao iMenuDao;
    @Resource
    private IRoleMenuDao iRoleMenuDao;
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


    /**
     * 2.根据当前菜单id，查询菜单中的子菜单，装入list
     * @param id
     * @param idList
     */
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

    /**
     * 给角色分配菜单权限（批量）
     * @param insertBO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveRoleMenuRalation(RoleMenuInsertBO insertBO){
        //初始化插入List
        List<RoleMenuDO> roleMenuList = new ArrayList<>();
        for (int i=0; i<insertBO.getMenuId().length; i++){
            //对RoleMenuDO进行封装
            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setId(new Random().nextLong());
            roleMenuDO.setIsUse(0);
            roleMenuDO.setRoleId(insertBO.getRoleId());
            roleMenuDO.setMenuId(insertBO.getMenuId()[i]);
            roleMenuDO.setCreateDate(LocalDateTime.now());
            roleMenuDO.setUpdateDate(LocalDateTime.now());
            System.out.println(roleMenuDO);
            roleMenuList.add(roleMenuDO);
        }
        //批量增加根据list
        iRoleMenuDao.batchInsert(roleMenuList);
    }

    /**
     * 插入菜单
     * @param menuInfoBO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void saveMenu(MenuInfoBO menuInfoBO) {
        MenuDO menuDO = new MenuDO();
        BeanUtils.copyProperties(menuDO, menuInfoBO);
        menuDO.setId(new Random().nextLong());
        menuDO.setCreateDate(LocalDateTime.now());
        menuDO.setUpdateDate(LocalDateTime.now());
        int insert = iMenuDao.insert(menuDO);
        if (insert != 1){
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }
    }

    /**
     * 根据id修改菜单
     * @param menuInfoBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateMenu(MenuInfoBO menuInfoBO) {
        MenuDO menuDO = new MenuDO();
        BeanUtils.copyProperties(menuDO, menuInfoBO);
        menuDO.setUpdateDate(LocalDateTime.now());
        int update = iMenuDao.updateById(menuDO);
        if (update != 1){
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    /**
     * 根据id获取菜单信息
     * @param menuInfoBO
     * @return
     */
    @Override
    public MenuInfoBO getRoleInfoById(MenuInfoBO menuInfoBO) {
        MenuDO menuDO = iMenuDao.selectById(menuInfoBO.getId());
        BeanUtils.copyProperties(menuInfoBO, menuDO);
        return menuInfoBO;
    }

    /**
     * 根据roleId获取菜单信息
     * @param roleId
     * @return
     */
    @Override
   public List<MenuInfoBO> getMenuInfoByRoleId(Long roleId){
       List<MenuDO> menuDOS = iMenuDao.find(null);//获取所有菜单
       List<MenuInfoBO> menuInfoBOS = BeanConvertUtils.convertList(menuDOS, MenuInfoBO.class);
       RoleMenuDO roleMenuDO = new RoleMenuDO();
       roleMenuDO.setRoleId(roleId);
       List<RoleMenuDO> roleMenuDOS = iRoleMenuDao.find(roleMenuDO);
       for (int m=0; m<menuInfoBOS.size(); m++){
           MenuInfoBO menuInfoBO = menuInfoBOS.get(m);
           for (int n=0; n<roleMenuDOS.size(); n++){
               RoleMenuDO roleMenuDO1 = roleMenuDOS.get(n);
               if (menuInfoBO.getId().equals(roleMenuDO1.getMenuId())){
                   menuInfoBO.setSelected(true);
               }
           }
       }
       List<MenuInfoBO> buildMenu = buildMenu(menuInfoBOS);
       return buildMenu;
   }
}
