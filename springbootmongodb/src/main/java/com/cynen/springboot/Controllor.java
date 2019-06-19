package com.cynen.springboot;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllor {

    @Autowired
    MongoTemplate template;


    @GetMapping("/")
    public String getData(){
        MongoCollection<Document> collection =  template.getCollection("spit");

        BasicDBObject bson=new BasicDBObject("visits",new  BasicDBObject("$gt",1000) );// 构建查询条件


        FindIterable<Document> documents = collection.find(bson).limit(1);//查询记录获取文档集合
        for(Document document:documents){ //
            System.out.println("内容："+ document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量："+document.getInteger("visits"));
            return document.getString("userid");
        }
        return  "" ;
    }



}
