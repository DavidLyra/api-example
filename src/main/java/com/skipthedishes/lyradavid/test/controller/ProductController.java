package com.skipthedishes.lyradavid.test.controller;

import com.skipthedishes.lyradavid.test.model.Product;
import com.skipthedishes.lyradavid.test.model.Store;
import com.skipthedishes.lyradavid.test.repository.ProductRepository;
import com.skipthedishes.lyradavid.test.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by david on 17/03/2018.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> productList() {
        return productRepository.findAll();
    }

    // Get All Products
    @GetMapping("/api/v1/product")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // Get a Single Product
    @GetMapping("/api/v1/product/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer productId) {
        return productRepository.findOne(productId);
    }
}