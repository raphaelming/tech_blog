//package com.raphael.blog.security;
//
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.JacksonJsonParser;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberOAuth2Tests {
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Autowired
//    private FilterChainProxy springSecurityFilterChain;
//    private String CONTENT_TYPE = "application/json;charset=UTF-8";;
//    private String SCOPE = "read";
//    private String CLIENT_ID = "foo";
//    private String CLIENT_SECRET = "bar";
//    private String SECURITY_USERNAME = "user";
//    private String SECURITY_PASSWORD = "test";
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).addFilter(springSecurityFilterChain).build();
//    }
//
//    @Test
//    public void callApiExpectUnauthorized() throws Exception {
//        mockMvc.perform(get("/members")).andExpect(status().isUnauthorized());
//    }
//
//    @Test
//    public void callMembersExpectSuccess() throws Exception {
//        String accessToken = obtainAccessToken(SECURITY_USERNAME, SECURITY_PASSWORD);
//        mockMvc.perform(get("/members")
//                .header("Authorization", "Bearer" + accessToken)
//                .accept(CONTENT_TYPE))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(CONTENT_TYPE));
//    }
//
//
//    @Test
//    public void callGetPostExpectSuccess() throws Exception {
//        JSONObject member = setMember();
//        String accessToken = obtainAccessToken(SECURITY_USERNAME, SECURITY_PASSWORD);
//        createMember(member, accessToken);
//        verifyMember(accessToken);
//    }
//
//
//    private void verifyMember(String accessToken) throws Exception {
//        mockMvc.perform(get("/members/1")
//                .header("Authorization", "Bearer" + accessToken)
//                .accept(CONTENT_TYPE))
//                .andExpect(jsonPath("$.username", is("test")));
//    }
//
//    private void createMember(JSONObject member, String accessToken) throws Exception {
//        mockMvc.perform(post("/members")
//                .header("Authorization", "Bearer" + accessToken)
//                .contentType(CONTENT_TYPE)
//                .content(member.toString())
//                .accept(CONTENT_TYPE))
//                .andExpect(status().isCreated());
//    }
//
//    private JSONObject setMember() throws JSONException {
//        JSONObject member = new JSONObject();
//        member.put("username", "test");
//        member.put("id", 14);
//        return member;
//    }
//
//
//    private String obtainAccessToken(String username, String password) throws Exception {
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "password");
//        params.add("client_id", CLIENT_ID);
//        params.add("username", username);
//        params.add("password", password);
//        params.add("scope", SCOPE);
//
//        ResultActions resultActions
//                = mockMvc.perform(post("/oauth/token")
//                .params(params)
//                .with(httpBasic(CLIENT_ID, CLIENT_SECRET))
//                .accept(CONTENT_TYPE))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(CONTENT_TYPE));
//
//        String resultString = resultActions.andReturn().getResponse().getContentAsString();
//
//        JacksonJsonParser jsonParser = new JacksonJsonParser();
//        return jsonParser.parseMap(resultString).get("access_token").toString();
//    }
//}
