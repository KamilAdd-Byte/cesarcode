package com.bazarek.bazarek.service;

import com.bazarek.bazarek.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    SessionFactory sessionFactory;

    Session session;

    @BeforeEach
    void setUp() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete User ").executeUpdate();
        session.getTransaction().commit();
    }

    @AfterEach
    void cleanUp() {
        session.close();
    }

    @Test
    void allUser() {
    }

    @Test
    @DisplayName("should add one user to database")
    void shouldAddOneUserOnDataBase() {
        //given
        User expected = new User();
        expected.setFirstName("Kamil");
        expected.setLastName("Lodziński");
        expected.setAge(36);
        //when
        userService.addUser(expected);

        User actual = (User) session.createQuery("from User u where u.firstName=:firstName and u.lastName=:lastName and u.age=:age")
                .setParameter("firstName", expected.getFirstName())
                .setParameter("lastName",expected.getLastName())
                .setParameter("age",expected.getAge())
                .getSingleResult();
        //then
        assertEquals(expected,actual);
    }
}
