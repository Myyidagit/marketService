package com.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: Xu
 * @Date: 2021/4/9 - 04 - 09 - 16:53
 * @Description: com.model
 * @version: 1.0
 */
@Data
@Document(collection = "classType")
public class ClassTypeModel {

    @Id
    private String _id;
    private int id;

    private String label;
}
