package com.raphael.blog.techblog.Controller;

import com.raphael.blog.techblog.Model.ExceptionPojo;
import com.raphael.blog.techblog.Model.Tag;
import com.raphael.blog.techblog.Service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;


    @GetMapping("{/id}")
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

    @DeleteMapping("{/id}")
    public ResponseEntity<ExceptionPojo> delete(@PathVariable Integer id) {
        tagService.delete(id);
        return new ResponseEntity<>(new ExceptionPojo(200, "OK", "success"), HttpStatus.OK);
    }

}
