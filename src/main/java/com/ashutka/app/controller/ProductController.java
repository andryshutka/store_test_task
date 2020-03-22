package com.ashutka.app.controller;

import com.ashutka.app.entity.Product;
import com.ashutka.app.help.PagedResult;
import com.ashutka.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public PagedResult<Product> getProducts(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size) {
        Page<Product> chunk = productRepository.findAll(PageRequest.of(page, size));
        return new PagedResult<>(chunk.getContent(), chunk.getTotalElements(), page);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong id"));
    }
}
