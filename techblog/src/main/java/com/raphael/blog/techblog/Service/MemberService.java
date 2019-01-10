package com.raphael.blog.techblog.Service;


import com.raphael.blog.techblog.Model.Member;
import com.raphael.blog.techblog.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> list() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member get(Integer id) {
        return memberRepository.findById(id).get();
    }
}
