package com.model;

import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: Xu
 * @Date: 2021/4/1 - 04 - 01 - 19:10
 * @Description: com.model
 * @version: 1.0
 */
@Data
@Document(collection = "goodsList")
public class GoodsModel {
    @Id
    private String _id;
    private String name;
    private String goodsDesc;
    private String cTime;
    private int price;
    private int classType;
    private int hotFlag;
    private int status;
    private int disCount;
}
