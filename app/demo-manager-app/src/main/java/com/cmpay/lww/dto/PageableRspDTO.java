package com.cmpay.lww.dto;


import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fuyux
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class PageableRspDTO<T> extends DefaultRspDTO<T> implements Pageable {
    /**
     * 页码，从1开始
     * 分页查询-第几页
     */
    private int pageNum;
    /**
     * 页面大小
     * 分页查询-每页数据条数
     */
    private int pageSize;
    /**
     * 起始行
     */
    private int startRow;
    /**
     * 末行
     */
    private int endRow;
    /**
     * 总数
     * 分页查询-总数
     */
    private long total;
    /**
     * 总页数
     * 分页查询-总页数
     */
    private int pages;

}