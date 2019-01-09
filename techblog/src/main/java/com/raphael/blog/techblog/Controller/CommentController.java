package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.Comment;
import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Repository.CommentRepository;
import com.raphael.blog.techblog.Service.BoardService;
import com.raphael.blog.techblog.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        Comment comment = commentService.get(id);
        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExceptionPojo> create(@RequestBody Comment comment) {
        commentService.create(comment);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Comment> comments() {
        return commentService.list();
    }



    @PutMapping
    public ResponseEntity<ExceptionPojo> insert(@RequestBody Comment comment) {
        commentService.insert(comment);
        return new ResponseEntity<>(new ExceptionPojo(201, "Updated", "success"),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExceptionPojo> delete(@PathVariable Integer id) {
        commentService.delete(id);
        return new ResponseEntity<>(new ExceptionPojo(200, "OK", "success"),HttpStatus.OK);
    }







}
