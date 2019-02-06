package com.raphael.blog.techblog;


import com.raphael.blog.techblog.Model.Member;
import com.raphael.blog.techblog.Model.Sample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SimpleOAuth2Tests {


    @Test
    public void simpleOAuth2Test() {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setUsername("user");
        resource.setPassword("test");
        resource.setAccessTokenUri("http://localhost:8080/oauth/token");
        resource.setClientId("foo");
        resource.setClientSecret("bar");
        resource.setGrantType("password");
        resource.setScope(Arrays.asList(new String[]{"read", "write", "trust"}));


        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
        Sample sample = restTemplate.getForObject("http://localhost:8080/", Sample.class);
        Assert.assertEquals("test", sample.getMessage());
    }

    @Test
    public void memberOAuth2Test() {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setUsername("user");
        resource.setPassword("test");
        resource.setAccessTokenUri("http://localhost:8080/oauth/token");
        resource.setClientId("foo");
        resource.setClientSecret("bar");
        resource.setGrantType("password");
        resource.setScope(Arrays.asList(new String[]{"read", "write", "trust"}));

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
        Member member = restTemplate.getForObject("http://localhost:8080/members/2", Member.class);
        Assert.assertEquals("test", member.getUserId());

    }
}
