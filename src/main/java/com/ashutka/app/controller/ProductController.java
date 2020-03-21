package com.ashutka.app.controller;

import com.ashutka.app.entity.Product;
import com.ashutka.app.help.PagedResult;
import com.ashutka.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public PagedResult<Product> products(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size) {
        Page<Product> chunk = productRepository.findAll(PageRequest.of(page, size));
        return new PagedResult<Product>(chunk.getContent(), chunk.getTotalElements(), page);
    }
}
