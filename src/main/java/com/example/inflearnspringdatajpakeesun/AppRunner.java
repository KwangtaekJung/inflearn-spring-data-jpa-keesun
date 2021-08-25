package com.example.inflearnspringdatajpakeesun;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class AppRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("jung");
        account.setPassword("spring");

        Study study = new Study();
        study.setName("Spring Data JPA");

//        account.getStudies().add(study); // 없어도 되지만 객체 관계를 생각했을 때 같이 설정함.
        study.setOwner(account);  // 주인쪽에 설정해줘야 함.
//        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
