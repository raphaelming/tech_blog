package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ApiResponseMessage;
import com.raphael.blog.techblog.Model.Board;
import com.raphael.blog.techblog.Model.Member;
import com.raphael.blog.techblog.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
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
            return new ApiResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, 500);
        }
    }

    @GetMapping("/list")
    public List<Member> list() {
        return memberRepository.findAll();
    }



}
