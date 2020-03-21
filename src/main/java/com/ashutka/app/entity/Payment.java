package com.ashutka.app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Payment extends org.bson.Document {

    @Id
    private String id;
    private String productId;
    private String cardNumber;
    private String expiresIn;
    private String cvv;
    private LocalDateTime paymentDate;
}
