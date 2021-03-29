package com.bazarek.bazarek.service;

import com.bazarek.bazarek.model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();

    void addUser(User user);
}
