package com.raphael.blog.techblog.Service;

import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board get(Integer id) {
        return boardRepository.findById(id).get();
    }

    public Board create(Board board) {
        boardRepository.save(board);
        return board;
    }

    @Transactional(readOnly = true)
    public List<Board> list() {
        return boardRepository.findAll();
    }

    public Board insert(Board board) {
        if(boardRepository.existsById(board.getId())) {
            board.setCreatedTimeAt(boardRepository.findById(board.getId()).get().getCreatedTimeAt());
            boardRepository.save(board);
            return board;
        }
        return null;
    }

    public void delete(Integer id) {
        boardRepository.delete(boardRepository.findById(id).get());
    }


}
