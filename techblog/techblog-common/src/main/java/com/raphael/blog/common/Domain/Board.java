package com.raphael.blog.common.Domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "contents")
    private String contents;

    @CreationTimestamp
    @Column(name = "created_time_at", updatable = false)
    private LocalDateTime createdTimeAt;

    @UpdateTimestamp
    private LocalDateTime updatedTimeAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    @JsonBackReference
    private Tag tag;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;



    public Board() {

    }

    public Board(Integer id) {
        this.id = id;
    }

    public Board(Tag tag) {
        this.tag = tag;
    }

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Board(String title, Tag tag, String contents) {
        this.title = title;
        this.tag = tag;
        this.contents = contents;
    }



}
