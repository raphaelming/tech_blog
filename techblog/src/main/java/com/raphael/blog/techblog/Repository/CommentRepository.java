package com.raphael.blog.techblog.Repository;


import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
