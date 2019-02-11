package com.raphael.blog.common.Repository;


import com.raphael.blog.common.Domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, Integer> {
}
