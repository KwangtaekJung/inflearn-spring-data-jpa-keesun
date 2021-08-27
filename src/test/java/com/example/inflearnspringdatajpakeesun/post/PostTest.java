package com.example.inflearnspringdatajpakeesun.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PostTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crud() {

    }
}