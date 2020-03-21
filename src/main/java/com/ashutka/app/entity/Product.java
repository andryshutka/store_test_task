package com.ashutka.app.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product extends org.bson.Document {

    @Id
    private String id;
    private String name;
    private String brand;
    private Double price;
    private String type;
    private long count;
    private String image;

}
