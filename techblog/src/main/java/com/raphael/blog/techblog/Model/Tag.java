package com.raphael.blog.techblog.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Board> boards = new ArrayList<>();

    public Tag() {

    }

    public Tag(Integer id) {
        this.id = id;
    }

    public Tag(String name) {
        this.name = name;
    }



}
