package com.example.inflearnspringdatajpakeesun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(value = false)
    public void crudRepository() {
        //given
        Post post = new Post();
        post.setTitle("Hello spring data common");
        assertThat(post.getId()).isNull();

        //when
        Post newPost = postRepository.save(post);

        //then
        assertThat(newPost.getId()).isNotNull();
        
        //when
        List<Post> posts = postRepository.findAll();
        
        //then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);
        
        //when
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //when
        page = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));
        //then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //when
        long spring = postRepository.countByTitleContains("spring");
        //when
        assertThat(spring).isEqualTo(1);
    }
}