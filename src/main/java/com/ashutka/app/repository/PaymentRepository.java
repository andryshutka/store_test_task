package com.ashutka.app.repository;

import com.ashutka.app.entity.Payment;
import com.ashutka.app.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
