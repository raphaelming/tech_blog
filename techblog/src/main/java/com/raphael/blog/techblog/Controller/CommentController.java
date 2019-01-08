package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Comment;
import com.raphael.blog.techblog.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponseMessage create(@RequestBody Comment comment) {
        try {
            commentRepository.save(comment);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.BAD_REQUEST,400, e);
        }
    }

    @GetMapping("")
    public List<Comment> list() {
        return commentRepository.findAll();
    }



    @PutMapping
    public ApiResponseMessage insert(@RequestBody Comment comment) {
        //TODO 예외처리 및 구조.. 수정할 것
        try {
            commentRepository.save(comment);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.BAD_REQUEST, 400,e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        //TODO 예외처리 및 구조.. 수정할 것
        commentRepository.delete(commentRepository.findById(id).get());
    }







}
