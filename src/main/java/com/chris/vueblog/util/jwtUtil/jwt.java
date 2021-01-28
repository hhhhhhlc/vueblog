package com.chris.vueblog.util.jwtUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwt {
    public static void main(String[] args) {
        String token ;
        token = createToken();
        System.out.println("=======token====="+token);
        parseToken(token);

    }

    // token由三部分组成，
    // 1. header
    // 2. payload
    // 3. sign

    // 生成token
    public static String createToken() {
         String scret="dsafa";
         int exp = 60;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 60);
        Map<String, Object> map = new HashMap<>();
        String token = JWT.create().withHeader(map).
                withClaim("username","chenlinhe").
                withClaim("password", "12345678").
                withExpiresAt(cal.getTime()).sign(Algorithm.HMAC256(scret));
        return token;
    }

    // 解析token
    public static void parseToken(String token) {
        JWTVerifier jwtv = JWT.require(Algorithm.HMAC256("dsafa")).build();
        DecodedJWT decodedJWT = jwtv.verify(token);
        System.out.println("username is ---"+decodedJWT.getClaim("username").asString());
        System.out.println("password is ---"+decodedJWT.getClaim("password").asString());
        System.out.println("=@@@@@@@@@@@@@@"+new Date().toString());
        System.out.println("password is ---"+decodedJWT.getExpiresAt().toString());
    }
}
