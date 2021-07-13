package com.bazarek.bazarek.hibernate;

import com.bazarek.bazarek.model.Movie;
import com.bazarek.bazarek.model.Training;
import com.bazarek.bazarek.model.User;
import com.bazarek.bazarek.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyApp {
    public static void main(String[] args) {
        //stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(UserDetail.class);
        conf.addAnnotatedClass(Movie.class);
        conf.addAnnotatedClass(Training.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobieranie sesji
        Session session = factory.getCurrentSession();



        session.beginTransaction();

        Training training = new Training();
        training.setName("Hibernate solutions");

        User john = new User();
        john.setFirstName("Waran");
        john.setLastName("Check");
        john.setAge(36);

        User bob = new User();
        bob.setFirstName("Bogdan");
        bob.setLastName("Wiśniewski");
        bob.setAge(49);

//        session.save(john);
//        session.save(bob);
        training.addUser(bob);
        training.addUser(john);

        session.persist(training);
        session.getTransaction().commit();

        //zamknięcie sesji
        factory.close();
    }
 }

