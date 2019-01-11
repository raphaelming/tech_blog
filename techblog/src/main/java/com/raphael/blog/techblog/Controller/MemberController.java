package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Model.Member;
import com.raphael.blog.techblog.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> members() {
        return memberService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        Member member = memberService.get(id);
        return new ResponseEntity(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExceptionPojo> create(@RequestBody Member member) {
        memberService.create(member);
        return new ResponseEntity<>(new ExceptionPojo(201, "created", "success"), HttpStatus.CREATED);
    }

}
