package com.bazarek.bazarek.hibernate;

import com.bazarek.bazarek.model.User;
import com.bazarek.bazarek.model.UserDetail;
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
        conf.addAnnotatedClass(UserDetail.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobieranie sesji
        Session session = factory.getCurrentSession();

        User user = new User();
        user.setId(3);
        user.setFirstName("Bogdan");
        user.setLastName("Sulejewska");
        user.setAge(31);

        UserDetail userDetail = new UserDetail();
        userDetail.setColorEyes("niebieskie");
        userDetail.setColorHair("blond");
        userDetail.setHeight(172.5);
        userDetail.setSpecialCharacters("okulary");
        user.setUserDetail(userDetail);
//        Address address = new Address();
//        address.setId(1);
//        address.setStreetName("Bratumiły");
//        address.setHouseNumber(4);
//        address.setFlatNumber(2);
//        address.setZipCode("61-608");
//        user.setAddress(address);

        session.beginTransaction();

        session.save(user);
        session.save(userDetail);

        session.getTransaction().commit();
        //zamknięcie sesji
        factory.close();
    }
}
