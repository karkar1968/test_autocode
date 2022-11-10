package com.epam.test.autocode.compare;

import com.epam.test.autocode.entity.User;

import java.util.Comparator;

public class UserFirstNameComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return 1;
//        return u1.getFirstName().compareTo(u2.getFirstName());
    }
}
