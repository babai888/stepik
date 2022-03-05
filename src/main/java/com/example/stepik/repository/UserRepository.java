package com.example.stepik.repository;

import com.example.stepik.model.Task;
import com.example.stepik.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    @Query("FROM User u WHERE u.login = :login")
    Collection<User> isUser(@Param("login") String login);

    Optional<User> findByLogin(String login);
}
