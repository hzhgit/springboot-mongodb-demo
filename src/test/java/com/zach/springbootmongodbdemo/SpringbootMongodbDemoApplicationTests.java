package com.zach.springbootmongodbdemo;

import com.zach.springbootmongodbdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@SpringBootTest
class SpringbootMongodbDemoApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void addTest() {
        User user1 = new User(1, "zach", "male");
        User user2 = new User(2, "york", "female");
        user1 = mongoTemplate.insert(user1);
        System.out.println(user1);
        user2 = mongoTemplate.insert(user2);
        System.out.println(user2);
    }

    @Test
    void findTest() {
        List<User> users = mongoTemplate.findAll(User.class);
        users.forEach(u -> {
            System.out.println(u.toString());
        });
    }

    @Test
    void updateTest() {
        mongoTemplate.updateFirst(query(where("id").is(1)), Update.update("name", "zach222"), User.class);
        Query query = Query.query(Criteria.where("id").is(1));
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users.get(0));
    }

    @Test
    void deleteTest() {
        User user1 = new User();
        User user2 = new User();
        user1.setId(1);
        user2.setId(2);
        mongoTemplate.remove(user1);
        mongoTemplate.remove(user2);

        List<User> users = mongoTemplate.findAll(User.class);
        users.forEach(u -> {
            System.out.println(u.toString());
        });
        System.out.println(users.size());
    }
}
