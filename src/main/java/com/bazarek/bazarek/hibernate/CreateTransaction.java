package com.bazarek.bazarek.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTransaction {
//    public static void main(String[] args) {
//        //stworzenie obiektu Configuration
//        Configuration conf = new Configuration();
//        //wczytanie pliku konfiguracyjnego
//        conf.configure("hibernate.cfg.xml");
//        //wczytanie adnotacji
//        conf.addAnnotatedClass(User.class);
//        conf.addAnnotatedClass(Paragon.class);
//        //stworzenie obiektu SessionFactory
//        SessionFactory factory = conf.buildSessionFactory();
//        //pobieranie sesji
//        Session session = factory.getCurrentSession();
//
//
//        Paragon paragon = new Paragon();
//        paragon.setPrice(45.65);
////        paragon.setShopName("Biedronka");
//
//
//        User user = new User();
//        user.setName("Kasia");
//        user.setParagon(paragon);
//
//        session.beginTransaction();
//        session.save(user);
//        paragon.setUser(user);
//
//        session.persist(paragon);
//
//        session.getTransaction().commit();
//        //zamknięcie sesji
//        factory.close();
//    }
}
