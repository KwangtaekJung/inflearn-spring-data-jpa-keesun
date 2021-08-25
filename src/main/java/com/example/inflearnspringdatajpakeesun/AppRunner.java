package com.example.inflearnspringdatajpakeesun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class AppRunner implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    Keesun keesun;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.findAll().forEach(System.out::println);

        System.out.println("=====================");
        System.out.println(keesun.getName());
    }
}
