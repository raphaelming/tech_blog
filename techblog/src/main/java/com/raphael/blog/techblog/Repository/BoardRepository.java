package com.raphael.blog.techblog.Repository;

import com.raphael.blog.techblog.Model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
