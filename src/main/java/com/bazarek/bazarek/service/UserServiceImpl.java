package com.bazarek.bazarek.service;

import com.bazarek.bazarek.dao.UserDao;
import com.bazarek.bazarek.model.User;
import com.bazarek.bazarek.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userRepository;

    @Override
    @Transactional
    public List<User> allUser() {
        return this.userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        //TODO
    }

    @Override
    @Transactional
    public void addUser(User user, UserDetail detail) {
        this.userRepository.save(user,detail);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
