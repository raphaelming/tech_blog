package com.raphael.blog.techblog.Repository;

import com.raphael.blog.techblog.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
