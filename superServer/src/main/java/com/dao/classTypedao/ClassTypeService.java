package com.dao.classTypedao;

import com.model.ClassTypeModel;
import com.model.CollectionIncId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @Auther: Xu
 * @Date: 2021/4/9 - 04 - 09 - 16:56
 * @Description: com.dao.classTypedao
 * @version: 1.0
 */
@Service
public class ClassTypeService {

    @Autowired
    private ClassTypedao classTypedao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List findAll(){
        List<ClassTypeModel> list = classTypedao.findAll();
        return list;
    }

    public void insertOne(ClassTypeModel classTypeModel){
        classTypedao.save(classTypeModel);
//        classTypedao.insert(classTypeModel);
    }

    /**
     * 根据_id删除一条数据
     */
    public void deleteOne(String id){
        classTypedao.delete(id);
    }

    /**
     *
     * @param collectionName 具体的表明
     * @return
     */
    public int getNextSequence(String collectionName) {

        FindAndModifyOptions options = new FindAndModifyOptions();
        // 先查询，如果没有符合条件的，会执行插入，插入的值是查询值 ＋ 更新值
        options.upsert(true);
        // 返回当前最新值
        options.returnNew(true);

        Update update = new Update();
        update.inc("id", 1);

        CollectionIncId collect = mongoTemplate.findAndModify(
                query(where("collName").is(collectionName)),
                update,
                options,
                CollectionIncId.class
        );
        System.out.println(where("id").toString());
        System.out.println(collect.toString());
        return collect.getId();
    }

}
