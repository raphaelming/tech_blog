package com.raphael.blog.api.Service;

import com.raphael.blog.common.Domain.Tag;
import com.raphael.blog.common.Repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(timeout = 20)
public class TagService {

    @Autowired
    private TagRepository tagRepository;


    public Tag get(Integer id) {
        return tagRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public List<Tag> list() {
        return tagRepository.findAll();
    }

    public void create(Tag tag) {
        tagRepository.save(tag);
    }

    public void insert(Tag tag) {
        if (tagRepository.existsById(tag.getId())) {
            tagRepository.save(tag);
        }
    }

    public void delete(Integer id) {
        tagRepository.delete(tagRepository.findById(id).get());
    }
}
