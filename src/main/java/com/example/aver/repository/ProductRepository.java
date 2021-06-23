package com.example.aver.repository;


import com.example.aver.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductRepository {

    public static final String HAS_KEY = "Product";


    @Autowired
    private RedisTemplate template;
    private HashOperations hashOperations;
    @PostConstruct
    private void init() {
        hashOperations = template.opsForHash();
    }

    public Product save(Product product){
        hashOperations.put(HAS_KEY, product.getId(),product);
        return product;
    }
    public List<Product> findAll(){
        return template.opsForHash().values(HAS_KEY);
    }

    public Product findById(int id){
        return (Product) template.opsForHash().get(HAS_KEY, id);
    }
    public String delete(int id){
        template.opsForHash().delete(HAS_KEY, id);
        return "deleted";
    }
}
