package com.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {
    @Query("SELECT u FROM SignUp u where u.email = :email")
    SignUp findByLogin(@Param("email") String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM SignUp u WHERE u.email = :email")
    boolean existsByLogin(@Param("email") String email);

    @Query("SELECT u FROM SignUp u WHERE u.signId = :signId")
    SignUp findOne(@Param("signId") long signId);

    @Query("SELECT u FROM SignUp u WHERE u.role like 'EMPLOYEE'")
    List<SignUp> findEmployee();
}
