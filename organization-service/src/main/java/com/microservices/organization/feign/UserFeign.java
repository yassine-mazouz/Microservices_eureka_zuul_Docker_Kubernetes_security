package com.microservices.organization.feign;

import com.microservices.organization.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "userFeign", url = "https://microservices-springboot.herokuapp.com:8081")
public interface UserFeign {
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    void postUsers(@RequestBody User user);
}
