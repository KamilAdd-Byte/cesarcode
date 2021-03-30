package com.bazarek.bazarek.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    @Autowired
    AddressService addressService;

    @Autowired
    SessionFactory sessionFactory;

    Session session;

    @BeforeEach
    void setUp() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete Address").executeUpdate();
        session.getTransaction().commit();
    }

    @AfterEach
    void cleanUp() {
        session.close();
    }

}
