package com.dao;

import com.model.GoodsModel;
import com.utils.Pagenation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * @Auther: Xu
 * @Date: 2021/4/6 - 04 - 06 - 16:16
 * @Description: com.dao
 * @version: 1.0
 */

public interface Commondao extends MongoRepository<GoodsModel,String> {

    public GoodsModel findByName(String name);
    public GoodsModel findBy_id(String id);
    public List<GoodsModel> findByNameLikeAndStatus(String name,int status);
    public Page<GoodsModel> findByNameLike(String name,Pageable pageable);
    public Page<GoodsModel> findByNameLikeAndStatus(String name, int status, Pageable pageable);

}

