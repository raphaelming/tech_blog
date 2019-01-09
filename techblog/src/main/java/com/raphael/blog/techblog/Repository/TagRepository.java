package com.raphael.blog.techblog.Repository;

import com.raphael.blog.techblog.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
