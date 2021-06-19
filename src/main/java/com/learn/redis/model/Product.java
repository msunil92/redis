package com.learn.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author sunil
 * @project redis
 * @created 2021/04/04 2:27 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash(value = "Product", timeToLive = 10)
public class Product implements Serializable {

    @Id
    int id;
    String name;
    int qty;
    long price;
}
