package com.ashutka.app.controller;

import com.ashutka.app.entity.Payment;
import com.ashutka.app.entity.Product;
import com.ashutka.app.repository.PaymentRepository;
import com.ashutka.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable String id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong id"));
    }

    @PostMapping
    public Payment buyProduct(@RequestBody Payment payment) {
        String productId = payment.getProductId();
        Optional<Product> product = productRepository.findById(productId);
        Payment result;
        if (product.isPresent()) {
            Product presentProduct = product.get();
            if (presentProduct.getCount() > payment.getQuantity()) {
                presentProduct.setCount(presentProduct.getCount() - payment.getQuantity());
                payment.setPaymentDate(LocalDateTime.now());
                productRepository.save(presentProduct);
                result = paymentRepository.save(payment);
            } else {
                throw new IllegalArgumentException("Don't have enough");
            }
        } else {
            throw new IllegalArgumentException("Could not find product with this ID");
        }

        return result;
    }
}
