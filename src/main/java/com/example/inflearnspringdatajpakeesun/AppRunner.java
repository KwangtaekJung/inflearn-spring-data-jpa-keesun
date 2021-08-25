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
        account.setUsername("keesun");
        account.setPassword("jpa");

        entityManager.persist(account);

        // Hibernate API(ex Session)도 직접 사용 가능함.
        Account account1 = new Account();
        account1.setUsername("jung");
        account1.setPassword("spring");
        Session session = entityManager.unwrap(Session.class);
        session.save(account1);
    }
}
