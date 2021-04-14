package com.dao;

import com.model.GoodsModel;
import com.utils.Pagenation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Xu
 * @Date: 2021/4/6 - 04 - 06 - 16:18
 * @Description: com.dao
 * @version: 1.0
 */
@Service
public class GoodsService {
    @Autowired
    private Commondao commondao;
    /**
     * id 数据的唯一标识_id
     */
    public GoodsModel findById(String id){
        GoodsModel goodsModel = commondao.findBy_id(id);
        return goodsModel;
    }

    /**
     * 条件查询并分页，并根据时间排序
     */
    public Page findnameLike(String name, int pageNum,int pageSize){
        Pagenation pagenation = new Pagenation();

        //每页显示条数
        pagenation.setPagesize(pageSize);
        //当前页
        pagenation.setPagenumber(pageNum-1);
        //根据创建时间排序
        Sort sort = new Sort(Sort.Direction.DESC, "cTime");
        pagenation.setSort(sort);
        Page<GoodsModel> pageList = commondao.findByNameLike(name,pagenation);
        return pageList;
    }

    /**
     * 插入一条
     */
    public void insertOne(GoodsModel goodsModel){
        commondao.save(goodsModel);
    }

    /**
     * 根据_id删除一条数据
     */
    public void deleteOne(String id){
        commondao.delete(id);
    }

    /**
     * 查询一条数据是否存在
     */
    public Boolean isExit(String id){
        return commondao.exists(id);
    }

    /**
     * 分页查询
     * @deprecated 根据名字模、上下架状态分页查询，再根据创建时间排序
     */

    public Page<GoodsModel> pageList(String name,int status, int pageNum,int pageSize) {

        Pagenation pagenation = new Pagenation();

        //每页显示条数
        pagenation.setPagesize(pageSize);
        //当前页
        pagenation.setPagenumber(pageNum-1);
        //根据创建时间排序
        Sort sort = new Sort(Sort.Direction.DESC, "cTime");
        pagenation.setSort(sort);

        Page<GoodsModel> pageList = commondao.findByNameLikeAndStatus(name,status,pagenation);

        return pageList;
    }
}
