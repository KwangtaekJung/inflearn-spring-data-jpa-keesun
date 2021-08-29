package com.example.inflearnspringdatajpakeesun.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;
    
    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment() {
        commentRepository.getById(1l);

        System.out.println("=============================");

        commentRepository.findById(1l);
    }
}