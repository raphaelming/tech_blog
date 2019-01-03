package com.raphael.blog.techblog;


import com.raphael.blog.techblog.Model.Board;
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
public class BoardJSONTests {
    private Board board;

    @Autowired
    private JacksonTester<Board> json;

    @Before
    public void setup() throws Exception {
        Board board = new Board("test", "test", "test");
        board.setId(1);
        this.board = board;
    }


    @Test
    public void deserializeJson() throws Exception {
        String content = "{\"tag\": \"test\", \"title\": \"test\", \"contents\": \"test\"}";
        assertThat(this.json.parse(content)).isEqualTo(new Board("test", "test", "test"));
        assertThat(this.json.parseObject(content).getTitle()).isEqualTo("test");
    }

    @Test
    public void serializeJson() throws Exception {
        assertThat(this.json.write(board)).isEqualTo("/com/raphael/blog/techblog/board.json");
        assertThat(this.json.write(board)).isEqualToJson("/com/raphael/blog/techblog/board.json");
        assertThat(this.json.write(board)).hasJsonPathStringValue("@.title");
        assertJsonPropertyEquals("@.title", "test");
        assertJsonPropertyEquals("@.tag", "test");
        assertJsonPropertyEquals("@.contents", "test");
    }

    private void assertJsonPropertyEquals(String key, String value) throws IOException {
        assertThat(this.json.write(board)).extractingJsonPathStringValue(key).isEqualTo(value);
    }

}
