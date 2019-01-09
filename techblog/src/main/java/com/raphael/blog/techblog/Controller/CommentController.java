package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Comment;
import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;


    @GetMapping("/{id}")
    public Comment get(@PathVariable Integer id) {
        return commentRepository.findById(id).get();
    }

    @PostMapping("")
    public ResponseEntity<ExceptionPojo> create(@RequestBody Comment comment) {
        comment.setRegDate(LocalDateTime.now());
        commentRepository.save(comment);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.OK);
    }

    @GetMapping("")
    public List<Comment> list() {
        return commentRepository.findAll();
    }



    @PutMapping
    public ResponseEntity<ExceptionPojo> insert(@RequestBody Comment comment) {
        //TODO 예외처리 및 구조.. 수정할 것
        comment.setRegDate(LocalDateTime.now());
        commentRepository.save(comment);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        //TODO 예외처리 및 구조.. 수정할 것
        commentRepository.delete(commentRepository.findById(id).get());
    }







}
