package com.kv.nosql.cosmos.mongo.api.dao;

import com.kv.nosql.cosmos.mongo.api.model.ProductsDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductsRepository extends ReactiveCrudRepository<ProductsDO,String> {
}
