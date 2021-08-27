package com.example.inflearnspringdatajpakeesun.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");

        assertThat(postRepository.contain(post)).isFalse();

        postRepository.save(post);

        postRepository.findMyPost();

        assertThat(postRepository.contain(post)).isTrue();

        postRepository.delete(post);
        postRepository.flush();
    }
}
