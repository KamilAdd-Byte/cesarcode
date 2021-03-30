package com.bazarek.bazarek.dao;

import com.bazarek.bazarek.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail,Long> {
}
