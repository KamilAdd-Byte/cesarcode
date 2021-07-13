package com.bazarek.bazarek.service;

import com.bazarek.bazarek.dao.UserDetailDao;
import com.bazarek.bazarek.model.Address;
import com.bazarek.bazarek.model.User;
import com.bazarek.bazarek.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailDao userDetailRepository;

    @Autowired
    SessionFactory sessionFactory;

    Session session;

    @BeforeEach
    void setUp() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete User ").executeUpdate();
        session.createQuery("delete UserDetail").executeUpdate();
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

        expected.setFirstName("Marian");
        expected.setLastName("Wąglewski");
        expected.setAge(67);

        UserDetail detail = new UserDetail();
        detail.setColorEyes("brązowe");
        detail.setColorHair("siwy");
        detail.setHeight(182.87);
        detail.setSpecialCharacters("tatuaż - smok na lewym ramieniu");
        expected.setUserDetail(detail);

        //when
        userDetailRepository.save(detail);
        userService.addUser(expected,detail);

        User actual = (User) session.createQuery("from User u where u.firstName=:firstName and u.lastName=:lastName and u.age=:age and u.userDetail=:userDetail")
                .setParameter("firstName", expected.getFirstName())
                .setParameter("lastName",expected.getLastName())
                .setParameter("age",expected.getAge())
                .setParameter("userDetail",expected.getUserDetail())
                .getSingleResult();
        //then
        assertThat(expected.getAge()).as("check age").isEqualTo(67);
        assertEquals(expected.hashCode(),actual.hashCode());
        assertThat(expected).isEqualTo(actual);
    }
}
