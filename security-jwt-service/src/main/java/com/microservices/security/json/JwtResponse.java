package com.microservices.security.json;

import lombok.Data;

import java.io.Serializable;
@Data
public class JwtResponse implements Serializable {

	private final String token;

}
