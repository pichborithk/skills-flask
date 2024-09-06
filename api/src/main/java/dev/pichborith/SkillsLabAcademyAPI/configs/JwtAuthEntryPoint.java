package dev.pichborith.SkillsLabAcademyAPI.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pichborith.SkillsLabAcademyAPI.dto.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        var responseBody = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                                             authException.getMessage());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), responseBody);
    }
}