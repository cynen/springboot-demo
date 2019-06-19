package com.cynen.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InsertTest {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("47.107.177.108", 8380);
        MongoDatabase database = client.getDatabase("test");

        MongoCollection spit = database.getCollection("spit");

        Map<String,Object> map=new HashMap();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        Document document=new Document(map);
        spit.insertOne(document);//插入数据
        client.close();




    }
}
