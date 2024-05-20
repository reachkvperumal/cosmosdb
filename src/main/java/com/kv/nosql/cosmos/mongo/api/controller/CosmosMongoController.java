package com.kv.nosql.cosmos.mongo.api.controller;

import com.kv.nosql.cosmos.mongo.api.dao.UserRepository;
import com.kv.nosql.cosmos.mongo.api.model.UserDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class CosmosMongoController {

    private final UserRepository repository;


    @GetMapping(value = "/all")
    Flux<UserDO> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping(value = "/addUsers")
    public Mono<List<String>> create(@RequestBody List<UserDO> userDO) {
        userDO.forEach(System.out::println);
        log.info("Total Count : {}", userDO.size());
        return repository.saveAll(userDO).map(UserDO::getId).collectList();
    }

    @GetMapping("/{id}")
    public Mono<UserDO> getUserById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PatchMapping("/update/{id}")
    public Mono<String> updateUserById(@PathVariable String id, @RequestBody UserDO user) {
        return repository.findById(id)
                .map(o -> user)
                .flatMap(repository::save)
                .map(UserDO::getId);
    }

    @DeleteMapping("/deleteAll")
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return repository.deleteById(id);
    }

}
