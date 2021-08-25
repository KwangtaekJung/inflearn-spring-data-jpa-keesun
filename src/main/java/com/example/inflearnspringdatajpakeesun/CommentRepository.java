package com.example.inflearnspringdatajpakeesun;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

    Comment save(Comment comment);

    List<Comment> findAll();

    long count();
}
