package com.example.inflearnspringdatajpakeesun.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Getter @Setter
@NamedQuery(name = "Post.findByTitleWithNamedQuery", query = "SELECT p FROM Post AS p WHERE p.title = ?1")
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
