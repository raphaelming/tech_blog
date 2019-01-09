package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Repository.BoardRepository;
import com.raphael.blog.techblog.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        Board board = boardService.get(id);
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExceptionPojo> create(@RequestBody Board board) {
        boardService.create(board);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"),HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Board> boards() {
        return boardService.list();
    }

    @PutMapping
    public ResponseEntity<ExceptionPojo> insert(@RequestBody Board board) {
        boardService.insert(board);
        return new ResponseEntity<>(new ExceptionPojo(201, "Updated", "success"),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExceptionPojo> delete(@PathVariable Integer id) {
        boardService.delete(id);
        return new ResponseEntity<>(new ExceptionPojo(200, "OK", "success"), HttpStatus.OK);
    }





}
