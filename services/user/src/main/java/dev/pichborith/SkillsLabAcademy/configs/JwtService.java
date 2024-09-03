package dev.pichborith.SkillsLabAcademy.configs;

import dev.pichborith.SkillsLabAcademy.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademy.user.User;
import dev.pichborith.SkillsLabAcademy.user.UserRepository;
import dev.pichborith.SkillsLabAcademy.user.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
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

//    @Value("${SECRET_KEY}")
//    private String secretKey;
//
//    @Value("${TOKEN_EXPIRATION}")
//    private long expiration;

    private final UserRepository userRepo;

    public String generateToken(UserResponse user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.id());
        return generateToken(map, user);
    }

    public String generateToken(Map<String, Object> extraClaims,
                                UserResponse user) {
        long expiration = 60;
        return buildToken(extraClaims, user, expiration);
    }

    public User validateToken(String token) {
        String email = getEmail(token);
        String userId = getUserId(token);
        if (email == null || userId == null) {
            throw new UnauthorizedException("Invalid token");
        }
        var userByEmail = userRepo.findByEmail(email).orElseThrow(
            () -> new UnauthorizedException("Invalid token"));
        var userById = userRepo.findById(userId).orElseThrow(
            () -> new UnauthorizedException("Invalid token"));

        if (!userByEmail.equals(userById) && checkExpiration(token)) {
            throw new UnauthorizedException("Invalid token");
        }

        return userById;
    }

    public String getEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String getUserId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("userId", String.class);
    }

    public boolean checkExpiration(String token) {
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
        return (Claims) Jwts
                            .parser()
                            .verifyWith(getSecretKey())
                            .build()
                            .parse(token)
                            .getPayload();
    }


    private String buildToken(
        Map<String, Object> extraClaims,
        UserResponse user,
        long expiration
    ) {
        return Jwts.builder()
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
