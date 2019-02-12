package com.raphael.blog.api.Service;


import com.raphael.blog.common.Domain.Board;
import com.raphael.blog.common.Repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout = 20)
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    @Autowired
    private BoardRepository boardRepository;


    public Board get(Integer id) {
        return boardRepository.findById(id).get();
    }

    public void create(Board board) {
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public List<Board> list() {
        return boardRepository.findAll();
    }

    public void insert(Board board) {
        if(boardRepository.existsById(board.getId())) {
            boardRepository.save(board);
        }
    }

    public void delete(Integer id) {
        boardRepository.delete(boardRepository.findById(id).get());
    }
}
