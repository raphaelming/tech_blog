package com.raphael.blog.techblog;


import com.raphael.blog.techblog.Model.Member;
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
public class MemberJSONTests {
    private Member member;

    @Autowired
    private JacksonTester<Member> json;

    @Before
    public void setup() throws Exception{
        Member member = new Member("test", "12345", "test", "test", "test@test.com", "gklsdfjsdlkfjdfalksdf");
        member.setId(1);
        this.member = member;
    }

    @Test
    public void deserializeJson() throws Exception{
        String content = "{\"userId\": \"test\", \"password\": \"12345\", " + "\"name\": \"test\", \"nickname\": \"test\", \"email\": \"test@test.com\", \"introduce\": \"gklsdfjsdlkfjdfalksdf\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Member("test", "12345", "test", "test", "test@test.com", "gklsdfjsdlkfjdfalksdf"));
        assertThat(this.json.parseObject(content).getUserId())
                .isEqualTo("test");
    }

    @Test
    public void serializeJson() throws Exception{
        assertThat(this.json.write(member)).isEqualTo("/com/raphael/blog/techblog/member.json");
        assertThat(this.json.write(member)).isEqualToJson("/com/raphael/blog/techblog/member.json");
        assertThat(this.json.write(member)).hasJsonPathStringValue("@.userId");
        assertJsonPropertyEquals("@.userId", "test");
        assertJsonPropertyEquals("@.password", "12345");
        assertJsonPropertyEquals("@.name", "test");
        assertJsonPropertyEquals("@.nickname", "test");
        assertJsonPropertyEquals("@.email", "test@test.com");
        assertJsonPropertyEquals("@.introduce", "gklsdfjsdlkfjdfalksdf");

    }


    private void assertJsonPropertyEquals(String key, String value) throws IOException {
        assertThat(this.json.write(member)).extractingJsonPathStringValue(key)
                .isEqualTo(value);
    }
}
