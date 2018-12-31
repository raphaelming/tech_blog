package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponseMessage create(@RequestBody Board board) {
        try {
            boardRepository.save(board);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500);
        }
    }

    @GetMapping("/list")
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @PutMapping
    public ApiResponseMessage insert(@RequestBody Board board) {
        //TODO 예외처리 및 구조.. 수정할 것
        try {
            boardRepository.save(board);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        //TODO 예외처리 및 구조.. 수정할 것
        boardRepository.delete(boardRepository.findById(id).get());
    }





}
