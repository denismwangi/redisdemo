package com.example.aver.controller;

import com.example.aver.entity.Product;
import com.example.aver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);

    }
    @GetMapping("/all")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Product findByid(@PathVariable int id){
       return productRepository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return productRepository.delete(id);
    }
}
