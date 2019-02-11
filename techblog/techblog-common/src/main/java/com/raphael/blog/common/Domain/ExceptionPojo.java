package com.raphael.blog.common.Domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionPojo {
    @JsonProperty(value = "status_code")
    private Integer status_code;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "message")
    private String message;

    public ExceptionPojo() {

    }

    public ExceptionPojo(Integer status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

    public ExceptionPojo(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public ExceptionPojo(Integer status_code, String type, String message) {
        this.status_code = status_code;
        this.type = type;
        this.message = message;
    }
}
