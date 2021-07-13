//package com.bazarek.bazarek.hibernate;
//
//
//import com.bazarek.bazarek.model.Movie;
//import com.bazarek.bazarek.model.User;
//import com.bazarek.bazarek.model.UserDetail;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class CreateTransactionOneToMany {
//
//    public static void main(String[] args) {
//        //stworzenie obiektu Configuration
//        Configuration conf = new Configuration();
//        //wczytanie pliku konfiguracyjnego
//        conf.configure("hibernate.cfg.xml");
//        //wczytanie adnotacji
//        conf.addAnnotatedClass(User.class);
//        conf.addAnnotatedClass(UserDetail.class);
//        conf.addAnnotatedClass(Movie.class);
//        //stworzenie obiektu SessionFactory
//        SessionFactory factory = conf.buildSessionFactory();
//        //pobieranie sesji
//        Session session = factory.getCurrentSession();
//
//        User user = new User();
//        user.setId(10);
//        user.setFirstName("Bartłomiej");
//        user.setLastName("Waran");
//        user.setAge(21);
//
//        UserDetail userDetail = new UserDetail();
//        userDetail.setColorEyes("szare");
//        userDetail.setColorHair("łysy");
//        userDetail.setHeight(192.5);
//        userDetail.setSpecialCharacters("tatuaż");
//        user.setUserDetail(userDetail);
////        Address address = new Address();
////        address.setId(1);
////        address.setStreetName("Bratumiły");
////        address.setHouseNumber(4);
////        address.setFlatNumber(2);
////        address.setZipCode("61-608");
////        user.setAddress(address);
//
//        Movie movie1 = new Movie();
//        movie1.setTitle("Batman");
//        movie1.setRating(8.78);
//        Movie movie2 = new Movie();
//        movie2.setTitle("Czarnobyl");
//        movie2.setRating(6.74);
//        Movie movie3 = new Movie();
//        movie3.setTitle("New Amsterdam");
//        movie3.setRating(8.1);
//
//        user.addMovies(movie1);
//        user.addMovies(movie2);
//        user.addMovies(movie3);
//
//        session.beginTransaction();
//
//        session.save(user);
//        session.save(userDetail);
//
//        session.getTransaction().commit();
//        //zamknięcie sesji
//        factory.close();
//    }
//
//}
