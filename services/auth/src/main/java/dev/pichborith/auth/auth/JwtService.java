package dev.pichborith.auth.auth;

import dev.pichborith.auth.user.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class JwtService {

//    @Value("${SECRET_KEY}")
//    private String secretKey;

//    @Value("${TOKEN_EXPIRATION}")
//    private int expiration;

    public String generateToken(UserResponse user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.id());
        return generateToken(map, user);
    }

    public String generateToken(Map<String, Object> extraClaims,
                                UserResponse user) {
        int expiration = 5;
        return buildToken(extraClaims, user, expiration);
    }


    private String buildToken(
        Map<String, Object> extraClaims,
        UserResponse user,
        long expiration
    ) {
        return Jwts
                   .builder()
                   .claims()
                   .add(extraClaims)
                   .subject(user.email())
                   .issuedAt(new Date(System.currentTimeMillis()))
                   .expiration(
                       new Date(System.currentTimeMillis() + expiration * 60 *1000))
                   .and()
                   .signWith(getSecretKey())
                   .compact();
    }


    private SecretKey getSecretKey() {
//        String sha512Hash = generateSHA512Hash(secretKey);
        String sha512Hash = generateSHA512Hash("secret");

        byte[] keyBytes = Decoders.BASE64.decode(sha512Hash);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String generateSHA512Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            byte[] hashBytes = digest.digest(
                input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(java.lang.String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 algorithm not found", e);
        }
    }
}
