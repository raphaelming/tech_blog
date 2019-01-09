package com.raphael.blog.techblog.Service;

import com.raphael.blog.techblog.Config.ApiExceptionHandler;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardRepository boardRepository;

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
            logger.info(String.valueOf(boardRepository.findById(board.getId()).get().getCreatedTimeAt()));
            board.setCreatedTimeAt(boardRepository.findById(board.getId()).get().getCreatedTimeAt());
            boardRepository.save(board);
        }
    }

    public void delete(Integer id) {
        boardRepository.delete(boardRepository.findById(id).get());
    }


}
