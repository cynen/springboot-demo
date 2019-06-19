package com.cynen.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * 条件查询
 *
 */
public class ConditionQuery {

    public static void main(String[] args) {
        MongoClient client = new MongoClient("47.107.177.108", 8380);
        MongoDatabase database = client.getDatabase("test");

        MongoCollection collection = database.getCollection("spit");

        // 访问超过 1000的.
        BasicDBObject bson=new BasicDBObject("visits",new  BasicDBObject("$gt",1000) );// 构建查询条件

        //  BasicDBObject bson=new BasicDBObject("userid","1013");// 构建查询条件 userid为1013的数据.
        FindIterable<Document> documents = collection.find(bson);//查询记录获取文档集合


        System.out.println(collection.count(bson));
        System.out.println(documents);
        for(Document document:documents){ //
            System.out.println("内容："+ document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
        }
        client.close();// 关闭连接




    }
}
