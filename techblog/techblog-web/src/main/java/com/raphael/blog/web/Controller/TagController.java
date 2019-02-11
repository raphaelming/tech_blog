package com.raphael.blog.web.Controller;


import com.raphael.blog.api.Service.TagService;
import com.raphael.blog.common.Domain.ExceptionPojo;
import com.raphael.blog.common.Domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        Tag tag = tagService.get(id);
        return new ResponseEntity(tag, HttpStatus.OK);

    }

    @GetMapping
    public List<Tag> tags() {
        return tagService.list();
    }

    @PostMapping
    public ResponseEntity<ExceptionPojo> create(@RequestBody Tag tag) {
        tagService.create(tag);
        return new ResponseEntity<>(new ExceptionPojo(201, "Created", "success"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ExceptionPojo> insert(@RequestBody Tag tag) {
        tagService.insert(tag);
        return new ResponseEntity<>(new ExceptionPojo(201, "Updated", "success"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExceptionPojo> delete(@PathVariable Integer id) {
        tagService.delete(id);
        return new ResponseEntity<>(new ExceptionPojo(200, "OK", "success"), HttpStatus.OK);
    }
}
