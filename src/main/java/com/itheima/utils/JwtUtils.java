package com.itheima.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

public class JwtUtils {
	private static final String SIGN_KEY = "itheima";
	private static final Long EXPIRE_TIME = 3600000L;

	public static String createToken(Map<String, Object> clamis) {
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, SIGN_KEY).setClaims(clamis).setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRE_TIME)).compact();
	}

	public static Map<String, Object> checkToken(String token) {
		return Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token).getBody();
	}
}
