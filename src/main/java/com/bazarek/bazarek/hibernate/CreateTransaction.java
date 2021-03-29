package com.bazarek.bazarek.hibernate;

import com.bazarek.bazarek.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTransaction {
    public static void main(String[] args) {
        //stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        conf.addAnnotatedClass(User.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobieranie sesji
        Session session = factory.getCurrentSession();

        User user = new User();
        user.setId(1);
        user.setFirstName("Kasia");
        user.setLastName("Sulejewska");
        user.setAge(31);

        session.beginTransaction();
        session.save(user);

        session.getTransaction().commit();
        //zamknięcie sesji
        factory.close();
    }
}
