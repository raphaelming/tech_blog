package com.raphael.blog.techblog;


import com.raphael.blog.techblog.Model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class CommentJSONTests {
    private Comment comment;

    @Autowired
    private JacksonTester<Comment> json;


    @Before
    public void setup() {
        Comment comment = new Comment("hello");
        comment.setId(1);
        this.comment = comment;
    }

    @Test
    public void deserializeJson() throws Exception{
        String content = "{\"contents\": \"hello\"}";
        assertThat(this.json.parse(content)).isEqualTo(new Comment("hello"));
        assertThat(this.json.parseObject(content).getContents()).isEqualTo("hello");

    }


    @Test
    public void serializeJson() throws Exception {
        assertThat(this.json.write(comment)).isEqualTo("/com/raphael/blog/techblog/comment.json");
        assertThat(this.json.write(comment)).isEqualToJson("/com/raphael/blog/techblog/comment.json");
        assertThat(this.json.write(comment)).hasJsonPathStringValue("@.contents");
        assertJsonPropertyEquals("@.contents", "hello");

    }

    private void assertJsonPropertyEquals(String key, String value) throws IOException {
        assertThat(this.json.write(comment)).extractingJsonPathStringValue(key).isEqualTo(value);
    }



}
