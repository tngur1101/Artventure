package com.ssafy.enjoytrip.util;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	private static final String SECRET_KEY = "ssafy"; // 시크릿 키, 토큰 생성과 검증 시 필요

	// JWT 토큰 생성 메소드
	public static String generateToken(MemberDto member) {
		long now = System.currentTimeMillis();
		long expirationSecond = 60*60*2;	//2시간

		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");
		
		Claims claims = Jwts.claims();
		claims.put("userId", member.getId());
		claims.put("userName", member.getName());
		claims.put("role", member.isAdmin());

		return Jwts.builder()
				.setHeader(header)
				.setClaims(claims)	//정보 담기
//				.setExpiration(new Date(now + 1000*expirationSecond)) // 토큰 만료 시간
				.setExpiration(new Date(1699591))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)		  // encoding 방식
				.compact();	//토큰 생성
	}

	// JWT 토큰 유효성 검증 메소드(SecretKey 필요)
	public static Jws<Claims> validateToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token);
	}

	// JWT 토큰 decode(SecretKey 필요X)
	public static String decodeToken(String token) {
		String[] splitToken = token.split("\\.");
		String body = splitToken[1];
		
		//디코딩
		Base64.Decoder decoder = Base64.getDecoder();
		String decodedBody = new String(decoder.decode(body));
		
		return decodedBody;
	}


	public static void main(String[] args) {
		// 테스트용 코드
		MemberDto member = new MemberDto();
		member.setId("ssafy");
		member.setName("ssafy");
		member.setAdmin(false);
		
		//토큰 생성
		String token = generateToken(member);
		System.out.println("생성된 토큰 : " + token);

		//토큰 디코딩 ( 단순 정보만 추출 ) => SecretKey 필요X 누구나 추출 가능 
		String decoded = decodeToken(token);
		System.out.println("디코딩된 토큰 : "+decoded);
		
		//유효성 검증 테스트 => SecretKey 필요 누구나 할 수 없음
		try {
			Jws<Claims> parsedToken = validateToken(token);
			System.out.println("Body: " + parsedToken.getBody());
			System.out.println("유효한 토큰.");
		} catch (Exception e) {
			System.out.println("유효하지 않거나 만료된 토큰.");
		}
	}
}
