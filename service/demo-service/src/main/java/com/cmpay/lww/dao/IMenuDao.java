/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:21:42
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.bo.MenuInfoBO;
import com.cmpay.lww.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMenuDao extends BaseDao<MenuDO, Long> {
    /**
     * 根据条件查询菜单
     * @return
     */
    List<MenuDO> selectByCondition();

    /**
     * 根据id进行更新
     * @param menuDO
     * @return
     */
    int updateById(MenuDO menuDO);

    /**
     * 批量删除菜单
     * @param list
     * @return
     */
    int deleteBatch(List<Long> list);

    /**
     * 根据id等到菜单信息
     * @param menuId
     * @return
     */
    MenuDO selectById(Long menuId);

}