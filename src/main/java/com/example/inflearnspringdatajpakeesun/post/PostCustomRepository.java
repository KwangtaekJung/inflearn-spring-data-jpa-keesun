package com.example.inflearnspringdatajpakeesun.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(T var1);
}
