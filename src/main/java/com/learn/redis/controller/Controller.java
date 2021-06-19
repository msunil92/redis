package com.learn.redis.controller;

import com.learn.redis.model.Product;
import com.learn.redis.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunil
 * @project redis
 * @created 2021/04/04 2:26 PM
 */

@RestController
@EnableCaching
@EnableScheduling
public class Controller {

    @Autowired
    ProductRepo productRepo;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductList() {
        return productRepo.getProductList();
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) {
        productRepo.save(product);
        return "Saved";
    }

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   // @Cacheable(cacheNames = "Product", key = "#id", value = "Product")
    public Product getProductListById(@PathVariable("id") int id) {
        return productRepo.getProductById(id);
    }

    @GetMapping(value = "/clear", produces = MediaType.APPLICATION_JSON_VALUE)
   // @CacheEvict(allEntries = true, cacheNames = "Product")
    //@Scheduled(fixedDelay = 10000)
    public String cleanCache() {
        System.out.println("Invokerd");
        return "Cache Cleared";
    }

}
