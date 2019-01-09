package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/{id}")
    public Board get(@PathVariable Integer id) {
            return boardRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<ExceptionPojo> create(@RequestBody Board board) {

        board.setRegDate(LocalDateTime.now());
        boardRepository.save(board);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.OK);
    }

    @GetMapping("")
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @PutMapping
    public ResponseEntity<ExceptionPojo> insert(@RequestBody Board board) {
        //TODO 예외처리 및 구조.. 수정할 것
        board.setRegDate(LocalDateTime.now());
        boardRepository.save(board);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        //TODO 예외처리 및 구조.. 수정할 것
        boardRepository.delete(boardRepository.findById(id).get());
    }





}
