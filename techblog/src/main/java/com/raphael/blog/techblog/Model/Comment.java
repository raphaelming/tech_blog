package com.raphael.blog.techblog.Model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contents")
    private String contents;

    private LocalDateTime regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


    public Comment() {

    }

    public Comment(String contents) {
        this.contents = contents;
    }

    public Comment(String contents, Board board) {
        this.contents = contents;
        this.board = board;
    }
}
