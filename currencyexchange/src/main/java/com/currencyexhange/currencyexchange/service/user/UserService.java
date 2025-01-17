package com.currencyexhange.currencyexchange.service.user;

import com.currencyexhange.currencyexchange.model.user.User;
import com.currencyexhange.currencyexchange.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User getUserByEmail(String email){
//        List<User> users = new ArrayList<>();
//        users.add(new User(1, "Alice", "alice@example.com", UserGroup.EMPLOYEE, new Date(2024, 0, 15)));
//        users.add(new User(2, "Bob", "bob@example.com", UserGroup.AFFILIATE, new Date(2020, 5, 20)));
//        users.add(new User(3, "Charlie", "charlie@example.com", UserGroup.CUSTOMER, new Date(2019, 7, 10)));

        User user = userRepository.findByEmail(email);

//        Optional<User> user = users.stream()
//                .filter(u -> u.getEmail().equalsIgnoreCase(email))
//                .findFirst();
//        if(user.isPresent()){
//            return user.get();
//        }
        return user;
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(Long.valueOf(id));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
