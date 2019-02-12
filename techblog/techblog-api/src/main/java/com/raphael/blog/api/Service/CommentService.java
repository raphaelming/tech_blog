package com.raphael.blog.api.Service;


import com.raphael.blog.common.Domain.Comment;
import com.raphael.blog.common.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout = 20)
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


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
            commentRepository.save(comment);
        }
    }

    public void delete(Integer id) {
        commentRepository.delete(commentRepository.findById(id).get());
    }
}
