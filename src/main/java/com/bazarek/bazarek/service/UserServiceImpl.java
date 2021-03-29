package com.bazarek.bazarek.service;

import com.bazarek.bazarek.dao.UserDao;
import com.bazarek.bazarek.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDao userRepository;

    @Override
    public List<User> allUser() {
        return this.userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        if (user != null){
            this.userRepository.save(user);
        }else
            throw new NullPointerException();
    }
}
