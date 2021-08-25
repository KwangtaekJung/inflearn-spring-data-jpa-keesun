package com.example.inflearnspringdatajpakeesun;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

    Comment save(Comment comment);

    List<Comment> findAll();

    List<Comment> findByCommentContains(String string);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    long count();
}
