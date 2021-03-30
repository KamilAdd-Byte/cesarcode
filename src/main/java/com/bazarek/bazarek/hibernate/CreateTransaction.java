package com.bazarek.bazarek.hibernate;

import com.bazarek.bazarek.model.Address;
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
        conf.addAnnotatedClass(Address.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobieranie sesji
        Session session = factory.getCurrentSession();

        User user = new User();
        user.setId(1);
        user.setFirstName("Kasia");
        user.setLastName("Sulejewska");
        user.setAge(31);

        Address address = new Address();
        address.setStreetName("Bratumiły");
        address.setHouseNumber(4);
        address.setFlatNumber(2);
        address.setZipCode("61-608");
        user.setAddress(address);
        address.setUser(user);

        session.beginTransaction();

        session.save(user);
        session.save(address);

        session.getTransaction().commit();
        //zamknięcie sesji
        factory.close();
    }
}
