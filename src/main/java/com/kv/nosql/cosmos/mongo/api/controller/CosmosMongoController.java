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
        userDO.stream().forEach(i -> System.out.println(i));
        log.info("Total Count : %s", userDO.size());
        return repository.saveAll(userDO).map(i -> i.getId()).collectList();
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
                .map(t -> t.getId());
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
