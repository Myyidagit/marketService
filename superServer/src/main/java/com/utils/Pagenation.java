package com.utils;

import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * @Auther: Xu
 * @Date: 2021/4/7 - 04 - 07 - 20:47
 * @Description: com.utils
 * @version: 1.0
 */
@Data
public class Pagenation implements Serializable, Pageable{
    private static final long serialVersionUID = 1L;
    // 当前页
    private int pagenumber = 1;
    // 当前页面条数
    private int pagesize = 10;
    //排序条件
    private Sort sort;

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Pagenation() {
        super();
    }

    @Override
    public int getPageNumber() {
        return this.pagenumber;
    }

    @Override
    public int getPageSize() {
        return this.pagesize;
    }

    /**
     * 第二页所需要增加的数量
     */
    @Override
    public int getOffset() {
        return this.pagenumber * this.pagesize;
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
