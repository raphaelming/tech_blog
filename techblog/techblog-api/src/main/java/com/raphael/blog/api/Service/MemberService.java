package com.raphael.blog.api.Service;


import com.raphael.blog.common.Domain.Member;
import com.raphael.blog.common.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    @Transactional(readOnly = true)
    public List<Member> list() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member get(Integer id) {
        return memberRepository.findById(id).get();
    }

    public void create(Member member) {
        memberRepository.save(member);
    }
}
