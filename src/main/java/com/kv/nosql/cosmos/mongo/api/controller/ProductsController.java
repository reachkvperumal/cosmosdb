package com.kv.nosql.cosmos.mongo.api.controller;

import com.kv.nosql.cosmos.mongo.api.dao.ProductsRepository;
import com.kv.nosql.cosmos.mongo.api.dao.UserRepository;
import com.kv.nosql.cosmos.mongo.api.model.ProductsDO;
import com.kv.nosql.cosmos.mongo.api.model.UserDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductsController {
    private final ProductsRepository repository;


    @GetMapping(value = "/all")
    Flux<ProductsDO> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping(value = "/addProducts")
    public Mono<List<String>> create(@RequestBody List<ProductsDO> products) {
        products.stream().forEach(i -> System.out.println(i));
        log.info("Total Count : %s", products.size());
        return repository.saveAll(products).map(i -> i.getId()).collectList();
    }

    @GetMapping("/{id}")
    public Mono<ProductsDO> getProductById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PatchMapping("/update/{id}")
    public Mono<String> updateUserById(@PathVariable String id, @RequestBody ProductsDO product) {
        return repository.findById(id)
                .map(o -> product)
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
