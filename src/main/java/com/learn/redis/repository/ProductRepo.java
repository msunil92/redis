package com.learn.redis.repository;

import com.learn.redis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunil
 * @project redis
 * @created 2021/04/04 2:36 PM
 */

@Service
public class ProductRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String HASH_KEY = "Product";

    public Product save(Product product) {
        System.out.println(product);
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> getProductList(){
        List<Product> products = redisTemplate.opsForHash().values(HASH_KEY);
        return products;
    }

    public Product getProductById(int id){
        System.out.println("Calling inside DB");

        Product product = (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
        return product;
    }

    public String deteteProductById(int id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Deleted";
    }
}
