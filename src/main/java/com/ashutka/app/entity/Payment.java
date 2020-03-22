package com.ashutka.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private String id;
    private String productId;
    private int quantity;
    private String cardNumber;
    private String expiresIn;
    private String cvv;
    private LocalDateTime paymentDate;
    private Double totalSum;
}
