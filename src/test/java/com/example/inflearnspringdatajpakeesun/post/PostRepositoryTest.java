package com.example.inflearnspringdatajpakeesun.post;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post); // persist

        Assertions.assertThat(entityManager.contains(post)).isTrue();
        Assertions.assertThat(entityManager.contains(savedPost)).isTrue();
        Assertions.assertThat(savedPost == post);


        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate); // merge

        Assertions.assertThat(entityManager.contains(updatedPost)).isTrue();
        Assertions.assertThat(entityManager.contains(postUpdate)).isFalse();
        Assertions.assertThat(updatedPost == postUpdate);

        List<Post> all = postRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
    }
}