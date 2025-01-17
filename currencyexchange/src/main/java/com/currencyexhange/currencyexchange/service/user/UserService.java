package com.currencyexhange.currencyexchange.service.user;

import com.currencyexhange.currencyexchange.model.user.User;
import com.currencyexhange.currencyexchange.model.user.UserGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public User getUserByEmail(String email){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", "alice@example.com", UserGroup.EMPLOYEE, new Date(2024, 0, 15)));
        users.add(new User(2, "Bob", "bob@example.com", UserGroup.AFFILIATE, new Date(2020, 5, 20)));
        users.add(new User(3, "Charlie", "charlie@example.com", UserGroup.CUSTOMER, new Date(2019, 7, 10)));

        Optional<User> user = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }
}
