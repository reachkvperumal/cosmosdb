package com.kv.nosql.cosmos.mongo.api.dao;

import com.kv.nosql.cosmos.mongo.api.model.UserDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserDO, String> {
}
