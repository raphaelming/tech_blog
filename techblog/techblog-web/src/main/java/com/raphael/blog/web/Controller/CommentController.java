package com.raphael.blog.web.Controller;


import com.raphael.blog.api.Service.CommentService;
import com.raphael.blog.common.Domain.Comment;
import com.raphael.blog.common.Domain.ExceptionPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;



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
