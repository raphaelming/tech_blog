package com.raphael.blog.techblog.Model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contents")
    private String contents;


    public Comment() {

    }

    public Comment(String contents) {
        this.contents = contents;
    }
}
