package com.raphael.blog.web.Controller;


import com.raphael.blog.common.Domain.Sample;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @CrossOrigin
    @GetMapping("/")
    Sample sample () {
        return new Sample("test");
    }
}
