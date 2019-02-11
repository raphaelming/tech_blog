package com.raphael.blog.common.Repository;


import com.raphael.blog.common.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
