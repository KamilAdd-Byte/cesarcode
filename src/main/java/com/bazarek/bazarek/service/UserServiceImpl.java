package com.bazarek.bazarek.service;

import com.bazarek.bazarek.dao.UserDao;
import com.bazarek.bazarek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userRepository;

    @Override
    public List<User> allUser() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }
}
