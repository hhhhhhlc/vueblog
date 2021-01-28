package com.chris.vueblog.util.jwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@ConfigurationProperties("jwt")
public class JwtUtils {

    private String secret;
    private long expire;
    private String header;

    /**
     * 生成token
     *
     * @return
     */
    public String createToken(long userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime()+ expire*1000);
        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 解析token
     * @param token
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 判断是否过期
     * true 为过期
     */
    public boolean isTokenExpired(Date expire) {
        return expire.before(new Date());
    }
}
