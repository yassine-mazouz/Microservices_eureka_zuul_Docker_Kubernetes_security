package com.microservices.site.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.site.model.User;

@FeignClient(name = "user-service")
public interface UserClient {
	
	@GetMapping("/site/{siteId}")
	List<User> findBySiteId(@PathVariable("siteId") Long siteId);
	
}
