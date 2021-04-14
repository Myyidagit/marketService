package com.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: Xu
 * @Date: 2021/4/12 - 04 - 12 - 15:55
 * @Description: com.model
 * @version: 1.0
 */
@Data
@Document(collection = "collectionIncId")
public class CollectionIncId {
    @Id
    private String _id;
    private int id;
    private String collName;
}
