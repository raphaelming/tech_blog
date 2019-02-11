package com.raphael.blog.web.Controller;


import com.raphael.blog.api.Service.BoardService;
import com.raphael.blog.common.Domain.Board;
import com.raphael.blog.common.Domain.ExceptionPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;




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
