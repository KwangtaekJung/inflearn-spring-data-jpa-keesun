package com.example.inflearnspringdatajpakeesun;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String comment;

    @ManyToOne
    private Post post;
}
