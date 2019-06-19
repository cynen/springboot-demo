package com.cynen.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

// 使用原生的mongodb的链接操作mongodb
// 链接上数据库,进行简单的查询. 查询全部.


public class MongoTest {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("47.107.177.108",8380);
        MongoDatabase database = client.getDatabase("test");
        // System.out.println(database.getName());

        MongoCollection collection = database.getCollection("spit");
        // System.out.println(collection);

        FindIterable<Document> documents = collection.find();//查询记录获取文档集合
        for(Document document:documents){ //
            System.out.println("内容："+ document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
       client.close();// 关闭连接

    }

}
