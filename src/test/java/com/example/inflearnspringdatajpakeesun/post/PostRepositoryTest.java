package com.example.inflearnspringdatajpakeesun.post;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        Assertions.assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleWithNamedQuery() {
        savePost();

        List<Post> all = postRepository.findByTitleWithNamedQuery("Spring Data JPA");
        Assertions.assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle() {
        savePost();

        List<Post> posts = postRepository.findByTitle("Spring Data JPA", JpaSort.unsafe("LENGTH(title)"));
        Assertions.assertThat(posts.size()).isEqualTo(1);
    }

    @Test
    public void updateTitle() {
        Post post = savePost();

        int update = postRepository.updateTitle("Hibernate", post.getId());
        Assertions.assertThat(update).isEqualTo(1);

        Optional<Post> byId = postRepository.findById(post.getId());
        Assertions.assertThat(byId.get().getTitle()).isEqualTo("hibernate");
    }

    @Test
    public void updateTitleWithDirtyCheck() {
        Post post = savePost();
        post.setTitle("Hibernate");

        List<Post> all = postRepository.findAll();
        Assertions.assertThat(all.get(0).getTitle()).isEqualTo("Hibernate");
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring Data JPA");
        return postRepository.save(post);
    }
}