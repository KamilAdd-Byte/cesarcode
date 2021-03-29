package com.bazarek.bazarek.dao;

import com.bazarek.bazarek.model.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
}
