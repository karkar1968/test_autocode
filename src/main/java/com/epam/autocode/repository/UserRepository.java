package com.epam.autocode.repository;

import com.epam.autocode.entity.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class UserRepository {
    Random r = new Random();

    public List<User> createUsers(Integer count) {

        return Stream.iterate(1, el -> el + 1)
                .limit(count)
                .map(i-> {
                    char c = (char)(r.nextInt(26) + 'a');
                    return new User(i.longValue(), c);
                })
                .toList();
    }
}

