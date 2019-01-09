package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.Member;
import com.raphael.blog.techblog.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
//@Slf4j
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/{id}")
    public Member get(@PathVariable Integer id) {
        return memberRepository.findById(id).get();
    }

    @PostMapping
    public ApiResponseMessage create(@RequestBody Member member) {
        try {
            memberRepository.save(member);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.BAD_REQUEST, 400);
        }
    }

    @GetMapping("")
    public List<Member> list() {
        return memberRepository.findAll();
    }

    @PutMapping
    public ApiResponseMessage insert(@RequestBody Member member) {
        //TODO 예외처리 및 구조.. 수정할 것
        try {
            memberRepository.save(member);
            return new ApiResponseMessage(HttpStatus.OK, 200);
        } catch (Exception e) {
            return new ApiResponseMessage(HttpStatus.BAD_REQUEST, 400);
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        memberRepository.delete(memberRepository.findById(id).get());
    }



}
