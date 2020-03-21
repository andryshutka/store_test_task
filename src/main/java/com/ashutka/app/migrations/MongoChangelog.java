package com.ashutka.app.migrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@ChangeLog(order = "001")
public class MongoChangelog {

    @ChangeSet(author = "ashutka", id="ash-001", order = "001")
    public void migrate001(MongoDatabase db) {
        db.createCollection("products");
        MongoCollection<Document> products = db.getCollection("products");
        List<Document> productList = new ArrayList<>();
        products.insertMany(productList);
    }
}
