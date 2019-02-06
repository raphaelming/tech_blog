package com.raphael.blog.techblog.Controller;


import com.raphael.blog.techblog.Model.Sample;
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
