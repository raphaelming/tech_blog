package com.raphael.blog.web.Controller;


import com.raphael.blog.api.Service.MemberService;
import com.raphael.blog.common.Domain.ExceptionPojo;
import com.raphael.blog.common.Domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;


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
