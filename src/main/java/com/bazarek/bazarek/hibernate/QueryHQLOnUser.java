//package com.bazarek.bazarek.hibernate;
//
//import com.bazarek.bazarek.model.Movie;
//import com.bazarek.bazarek.model.User;
//import com.bazarek.bazarek.model.UserDetail;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Set;
//
//public class QueryHQLOnUser {
//    public static void main(String[] args) {
//                //stworzenie obiektu Configuration
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
//        int number = 0;
//        long id = 34;
//
//        session.beginTransaction();
//
//        User user = session.get(User.class,id);
//        System.out.println("To nasz USER: "+user);
//
//        Set<Movie> userMovies = user.getMovies();
//        for (Movie userMovie : userMovies) {
//            System.out.println(userMovie);
//        }
//
//        session.getTransaction().commit();
//
//        //zamknięcie sesji
//        factory.close();
//    }
//}

