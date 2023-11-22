package com.ssafy.enjoytrip.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.enjoytrip.util.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //GET, OPTIONS 요청의 경우 모두 허용
        String method = request.getMethod();
        log.debug("Intercept된 요청 Method:{}", method);

        System.out.println("Intercept된 요청 Method : " + method);
        if(method.equals("GET") || method.equals("OPTIONS") ) return true;

        final String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            log.debug("토큰이 없음");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }

        try {
            
            String jwtToken = token.substring(7); // "Bearer " 이후의 토큰 부분 추출
            // 토큰 검증 로직 구현
            Jws<Claims> parsedToken = JWTUtil.validateToken(jwtToken);
//            System.out.println("Body: " + parsedToken.getBody());

            // 필요한 경우 클레임 내용을 확인하여 유효성을 추가로 검증할 수 있음

            // 검증에 성공한 경우 계속 진행
            return true;

        } catch (Exception e) {
            log.debug("만료된 토큰이거나 유효하지 않은 토큰, 에러내용 : {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Expired");
            return false;
        }
    }
}
