package com.example.inflearnspringdatajpakeesun.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    @Query("SELECT p FROM Post AS p WHERE p.title = ?1")
    List<Post> findByTitle(String title, Sort sort);

    List<Post> findByTitleWithNamedQuery(String title);

    @Modifying
    @Query("UPDATE Post p Set p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String title, Long id);

}
