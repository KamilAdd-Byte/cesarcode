package com.bazarek.bazarek.service;

import com.bazarek.bazarek.model.User;
import com.bazarek.bazarek.model.UserDetail;

import java.util.List;

public interface UserService {
    List<User> allUser ();
    void addUser (User user, UserDetail detail);
    void delete(User user);
}
