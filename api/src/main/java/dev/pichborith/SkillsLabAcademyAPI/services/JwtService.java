package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademyAPI.models.User;
import dev.pichborith.SkillsLabAcademyAPI.repositories.UserRepo;
import io.jsonwebtoken.Claims;
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
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${SECRET_KEY}")
    private String secretKey;

    @Value("${TOKEN_EXPIRATION}")
    private int expiration;

    private final UserRepo userRepo;

    public String generateToken(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getId());
        return generateToken(map, user);
    }

    public String generateToken(Map<String, Object> extraClaims,
                                User user) {
        return buildToken(extraClaims, user, expiration);
    }

    public User validateToken(String token) {
        String username = getUsername(token);
        Integer userId = getUserId(token);
        if (username == null || userId == null) {
            throw new UnauthorizedException("Invalid token");
        }
        User userByUsername = userRepo.findByUsername(username).orElseThrow(
            () -> new UnauthorizedException("Invalid token"));
        User userById = userRepo.findById(userId).orElseThrow(
            () -> new UnauthorizedException("Invalid token"));

        if (!userByUsername.equals(userById) && checkExpiration(token)) {
            throw new UnauthorizedException("Invalid token");
        }
        return userByUsername;
    }

    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Integer getUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", Integer.class);
    }

    private boolean checkExpiration(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token,
                               Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return (Claims) Jwts.parser()
                            .verifyWith(getSecretKey())
                            .build()
                            .parse(token)
                            .getPayload();
    }

    private String buildToken(Map<String, Object> extraClaims, User user,
                              long expiration) {
        return Jwts.builder()
                   .claims()
                   .add(extraClaims)
                   .subject(user.getUsername())
                   .issuedAt(new Date(System.currentTimeMillis()))
                   .expiration(
                       new Date(
                           System.currentTimeMillis() + expiration * 60 * 1000))
                   .and()
                   .signWith(getSecretKey())
                   .compact();
    }

    private SecretKey getSecretKey() {
        String sha512Hash = generateSHA512Hash(secretKey);

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


