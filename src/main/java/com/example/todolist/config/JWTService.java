package com.example.todolist.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//유효성 검사
@Service
public class JWTService {

    private final Key key;

    //키 값, key decode
    public JWTService(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    //토큰 생성 반환
    public String generateToken(Map<String, Object>
                                        extractClaims,
                                UserDetails userDetails)
    {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    //사용자 세부 정보로만 토큰 생성
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    //토큰 검증
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //토큰 유효일 검사
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //토큰 추출 만료
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //클레임 추출, 토큰을 Claims 만드는 메소드
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {

        return  extractClaim(token, Claims::getSubject);
    }


}
