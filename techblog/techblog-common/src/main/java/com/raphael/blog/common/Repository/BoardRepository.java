package com.raphael.blog.common.Repository;

import com.raphael.blog.common.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
