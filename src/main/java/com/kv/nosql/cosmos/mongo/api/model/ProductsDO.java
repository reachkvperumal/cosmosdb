package com.kv.nosql.cosmos.mongo.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Document(collection = "products")
@Sharded(shardKey = "productName")
public class ProductsDO {

    @Id
    private String id;
    private String productName;
    private String desc;
    private String category;

}