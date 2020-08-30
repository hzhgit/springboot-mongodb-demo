package com.zach.springbootmongodbdemo;

import com.zach.springbootmongodbdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class SpringbootMongodbDemoApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void addTest() {
        User user1 = new User(1,"zach","male");
        User user2 = new User(2,"york","female");
        user1 = mongoTemplate.insert(user1);
        System.out.println(user1);
        user2 = mongoTemplate.insert(user2);
        System.out.println(user2);
    }

}
