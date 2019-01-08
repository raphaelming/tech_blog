package com.raphael.blog.techblog.Model;


import lombok.Data;

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

    private LocalDateTime regDate;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<Board> boards = new ArrayList<>();


}
