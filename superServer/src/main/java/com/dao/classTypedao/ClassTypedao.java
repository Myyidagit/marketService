package com.dao.classTypedao;

import com.model.ClassTypeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Auther: Xu
 * @Date: 2021/4/9 - 04 - 09 - 16:52
 * @Description: com.dao.classTypedao
 * @version: 1.0
 */
public interface ClassTypedao extends MongoRepository<ClassTypeModel,String> {
}
