package com.raphael.blog.techblog.Service;


import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.Comment;
import com.raphael.blog.techblog.Repository.BoardRepository;
import com.raphael.blog.techblog.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(timeout = 20)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment get(Integer id) {
        return commentRepository.findById(id).get();
    }

    public void create(Comment comment) {
        commentRepository.save(comment);
    }
    @Transactional(readOnly = true)
    public List<Comment> list() {
        return commentRepository.findAll();
    }

    public void insert(Comment comment) {
        if (commentRepository.existsById(comment.getId())) {
            comment.setCreatedTimeAt(commentRepository.findById(comment.getId()).get().getCreatedTimeAt());
            commentRepository.save(comment);
        }
    }

    public void delete(Integer id) {
        commentRepository.delete(commentRepository.findById(id).get());
    }
}
