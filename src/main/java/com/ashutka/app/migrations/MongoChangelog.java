package com.ashutka.app.migrations;

import com.ashutka.app.entity.Product;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.google.common.collect.Lists;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.util.ReflectionUtils;

import javax.print.Doc;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ChangeLog(order = "001")
public class MongoChangelog {

    @ChangeSet(author = "ashutka", id="ash-001", order = "001")
    public void migrate001(MongoDatabase db) {
        System.out.println("products migration");
        db.createCollection("products");
        MongoCollection<Document> products = db.getCollection("products");
        List<Document> productList = testProducts().stream().map(product -> {
            try {
                return convertProductToDocument(product);
            } catch (ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        products.insertMany(productList);
    }

    @ChangeSet(author = "ashutka", id="ash-002", order = "002")
    public void migrate002(MongoDatabase db) {
        System.out.println("payments migration");
        db.createCollection("payments");
    }

    private Document convertProductToDocument(Product product) throws ClassNotFoundException, IllegalAccessException {
        Document document = new Document();
        Field[] fields = Class.forName("com.ashutka.app.entity.Product").getDeclaredFields();
        for (Field f : fields) {
            String fName = f.getName();
            if (!fName.equals("id")) {
                f.setAccessible(true);
                document.put(fName, f.get(product));
            }
        }

        return document;
    }

    private List<Product> testProducts() {
        return Lists.newArrayList(
                Product.builder().
                        brand("CUBE")
                        .count(65)
                        .price(555.99)
                        .name("X-01")
                        .image("https://place-hold.it/300x300")
                        .type("bicycle")
                        .build(),
                Product.builder().
                        brand("Apple")
                        .count(53)
                        .price(999.99)
                        .name("iPhone")
                        .image("https://place-hold.it/300x300")
                        .type("smartphone")
                        .build(),
                Product.builder().
                        brand("Google")
                        .count(45)
                        .price(855.99)
                        .name("Pixel")
                        .image("https://place-hold.it/300x300")
                        .type("smartphone")
                        .build(),
                Product.builder().
                        brand("Tesla")
                        .count(3)
                        .price(100500.00)
                        .name("Model X")
                        .image("https://place-hold.it/300x300")
                        .type("car")
                        .build(),
                Product.builder().
                        brand("Opel")
                        .count(8)
                        .price(4500.00)
                        .name("Astra")
                        .image("https://place-hold.it/300x300")
                        .type("car")
                        .build(),
                Product.builder().
                        brand("Microsoft")
                        .count(9)
                        .price(400.00)
                        .name("XBOX")
                        .image("https://place-hold.it/300x300")
                        .type("console")
                        .build(),
                Product.builder().
                        brand("Sony")
                        .count(4)
                        .price(400.00)
                        .name("PS 4")
                        .image("https://place-hold.it/300x300")
                        .type("console")
                        .build(),
                Product.builder().
                        brand("A4Tech")
                        .count(2)
                        .price(40.00)
                        .name("KD-400")
                        .image("https://place-hold.it/300x300")
                        .type("keyboard")
                        .build(),
                Product.builder().
                        brand("A4Tech")
                        .count(0)
                        .price(10.00)
                        .name("Moussse")
                        .image("https://place-hold.it/300x300")
                        .type("Mouse")
                        .build(),
                Product.builder().
                        brand("A4Tech")
                        .count(0)
                        .price(10.00)
                        .name("Moussse")
                        .image("https://place-hold.it/300x300")
                        .type("Mouse")
                        .build(),
                Product.builder().
                        brand("HP")
                        .count(0)
                        .price(10.00)
                        .name("Fantastic Beasts and where to find them")
                        .image("https://place-hold.it/300x300")
                        .type("Book")
                        .build(),
                Product.builder().
                        brand("Asus")
                        .count(0)
                        .price(450.00)
                        .name("Zenbook")
                        .image("https://place-hold.it/300x300")
                        .type("Notebook")
                        .build(),
                Product.builder().
                        brand("Samsung")
                        .count(7)
                        .price(450.00)
                        .name("G-12323-FSD")
                        .image("https://place-hold.it/300x300")
                        .type("TV")
                        .build(),
                Product.builder().
                        brand("Absolute")
                        .count(2)
                        .price(450.00)
                        .name("Vodka")
                        .image("https://place-hold.it/300x300")
                        .type("Drink")
                        .build(),
                Product.builder().
                        brand("Jacobs")
                        .count(65)
                        .price(20.00)
                        .name("Coffee")
                        .image("https://place-hold.it/300x300")
                        .type("Drink")
                        .build(),
                Product.builder().
                        brand("Artek")
                        .count(150)
                        .price(2.0)
                        .name("Waffles")
                        .image("https://place-hold.it/300x300")
                        .type("Food")
                        .build(),
                Product.builder().
                        brand("Apple")
                        .count(73)
                        .price(2450.00)
                        .name("MacBook Pro")
                        .image("https://place-hold.it/300x300")
                        .type("Laptop")
                        .build(),
                Product.builder().
                        brand("Bosch")
                        .count(89)
                        .price(200.00)
                        .name("FAA-423")
                        .image("https://place-hold.it/300x300")
                        .type("Washing machine")
                        .build(),
                Product.builder().
                        brand("Bosch")
                        .count(73)
                        .price(2450.00)
                        .name("FAA-423")
                        .image("https://place-hold.it/300x300")
                        .type("Washing machine")
                        .build(),
                Product.builder().
                        brand("Morshinska")
                        .count(1500)
                        .price(1.0)
                        .name("Without bubbles")
                        .image("https://place-hold.it/300x300")
                        .type("Water")
                        .build(),
                Product.builder().
                        brand("Darnitsa")
                        .count(3)
                        .price(2.0)
                        .name("Ibuprofen")
                        .image("https://place-hold.it/300x300")
                        .type("Medicine")
                        .build(),
                Product.builder().
                        brand("GSC")
                        .count(7)
                        .price(5.0)
                        .name("Stalker Game")
                        .image("https://place-hold.it/300x300")
                        .type("DVD")
                        .build(),
                Product.builder().
                        brand("Gilette")
                        .count(560)
                        .price(7.0)
                        .name("Razor")
                        .image("https://place-hold.it/300x300")
                        .type("Hygiene products")
                        .build(),
                Product.builder().
                        brand("Safeguard")
                        .count(4)
                        .price(3.0)
                        .name("Soap")
                        .image("https://place-hold.it/300x300")
                        .type("Hygiene products")
                        .build(),
                Product.builder().
                        brand("Roshen")
                        .count(765)
                        .price(3.0)
                        .name("Chocolate")
                        .image("https://place-hold.it/300x300")
                        .type("Sweets")
                        .build(),
                Product.builder().
                        brand("Danone")
                        .count(45)
                        .price(3.0)
                        .name("Rostishka")
                        .image("https://place-hold.it/300x300")
                        .type("Dairy")
                        .build()
                );
    }
}
