package com.cognizant.spring_learn.security;

import com.cognizant.spring_learn.controller.AuthenticationController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Custom security filter intercepting stateless HTTP requests to process JWT access verification checks.
 * Integrates into the core Spring filter architecture by extending BasicAuthenticationFilter.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    /**
     * Initializes the verification component with a reference to the active authentication manager.
     *
     * @param authenticationManager Engine instance regulating framework authentication workflows.
     */
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("START - Initializing JwtAuthorizationFilter layout structures");
        LOGGER.debug("Assigned operational authentication manager: {}", authenticationManager);
    }

    /**
     * Intercepts execution requests to check for the presence of a valid Bearer token signature.
     * Validates credentials and passes user contexts directly to the Spring Context holder.
     * Employs type-use nullability annotations to comply with parent class parameter constraints.
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest req,
            @NonNull HttpServletResponse res,
            @NonNull FilterChain chain) throws IOException, ServletException {
        LOGGER.info("START - Intercepting request stream to review Bearer token validation attributes");
        String header = req.getHeader("Authorization");
        LOGGER.debug("Raw request authorization header content caught: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            LOGGER.info("Bearer prefix missing or empty; skipping to subsequent filter handlers");
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        LOGGER.info("END - Internal security validation routing intercept processed successfully");
    }

    /**
     * Decodes and validates the cryptographic token payload matching server context keys.
     * Returns an authenticated framework token profile upon successful parsing validation.
     *
     * @param request Inbound servlet request capture object.
     * @return Standard authenticated user principal token payload, or null if validation fails.
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                Jws<Claims> jws = Jwts.parserBuilder()
                        .setSigningKey(AuthenticationController.SIGNING_KEY)
                        .build()
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String user = jws.getBody().getSubject();
                LOGGER.debug("JWT filter payload successfully verified identity for user: {}", user);

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                LOGGER.error("JWT validation failure detected inside security intercept pipeline: {}", ex.getMessage());
                return null;
            }
        }
        return null;
    }
}