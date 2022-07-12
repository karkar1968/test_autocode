package com.epam.test.autocode.repository;

import com.epam.test.autocode.compare.UserFirstNameComparator;
import com.epam.test.autocode.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    private List<User> testUsers = new ArrayList<>();
    private UserRepository repository = new UserRepository();
    private UserFirstNameComparator firstNameComparator = new UserFirstNameComparator();
    private Integer initUserCount = 9;
    private Comparator<User> userFNC = Comparator.comparing(User::getFirstName);
    private Comparator<User> userLNC = Comparator.comparing(User::getLastName);

    @BeforeAll
    public void init() {
        testUsers  = repository.createUsers(initUserCount);
    }
    @Test
    void givenUserFirstNameComparator_whenUsersCompare_thenSuccess(){

        List<User> afterComparing = testUsers.stream()
                .sorted(firstNameComparator)
                .collect(Collectors.toList());

        assertFalse(isSorted(afterComparing, userFNC));
    }

    boolean isSorted(List<User> users, Comparator<User> comparator) {
        for (int i = 0; i < users.size() - 1; ++i) {
            if (comparator.compare(users.get(i), users.get(i + 1)) > 0)
                return false;
        }
        return true;
    }
}