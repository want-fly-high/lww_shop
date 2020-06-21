/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-21 10:21:42
 */
package com.cmpay.lww.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.lww.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMenuDao extends BaseDao<MenuDO, Long> {
    List<MenuDO> selectByCondition();

    //根据id进行更新
    int updateById(MenuDO menuDO);

    int deleteBatch(List<Long> list);

}