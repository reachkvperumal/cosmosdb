package com.kv.nosql.cosmos.mongo.api.dao;

import com.kv.nosql.cosmos.mongo.api.model.ProductsDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductsRepository extends ReactiveCrudRepository<ProductsDO, String> {

    Flux<ProductsDO> findByProductName(String productName);
}
