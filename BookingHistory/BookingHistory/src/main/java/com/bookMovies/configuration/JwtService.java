package com.bookMovies.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey=null;
//    public String generateToken(Users user){
//        Map<String,Object> claims=new HashMap<>();
//        claims.put("role",user.getRole().toString());
//        return Jwts
//                .builder()
//                .claims(claims)
//                .subject(user.getEmail())
//                .issuer("Mohith")
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis()+ 60*10*1000))
//                .signWith(generateKey())
//                .compact();
//    }

    private SecretKey generateKey(){
        byte[] decode = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }
    public String getSecretKey(){
        return secretKey="fb42b50c4312c781d5a512635cae0cc4992265eda86f5a890ba3137063c6bf5b";
    }

    public String extractRole(String token){
        return extractClaims(token,claims -> claims.get("role",String.class));
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
        Claims claims=Jwts.parser()
                          .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claimResolver.apply(claims);

    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    private Date extractExpirationDate(String token) {
        return extractClaims(token,Claims::getExpiration);
    }
}
