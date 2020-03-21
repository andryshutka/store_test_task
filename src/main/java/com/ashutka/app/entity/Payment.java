package com.ashutka.app.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private String productId;
    private int quantity;
    private String cardNumber;
    private String expiresIn;
    private String cvv;
    private LocalDateTime paymentDate;
}
