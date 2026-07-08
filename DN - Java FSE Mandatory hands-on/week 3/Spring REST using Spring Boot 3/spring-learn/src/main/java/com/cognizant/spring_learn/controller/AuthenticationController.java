package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller responsible for processing user authentication and token issuance.
 * Leverages the JJWT library to formulate securely signed JSON Web Tokens for client-side state maintenance.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    /**
     * Shared cryptographic secret key mapping to the HMAC-SHA256 signature algorithm requirement.
     * Engineered with at least 256 bits of key space to comply with secure Spring Boot 3 standards.
     */
    public static final Key SIGNING_KEY = Keys.hmacShaKeyFor(
            "universityEvaluatorSecureSigningKeySecretRequirementHS256Compliance32BytesMinimumLength"
                    .getBytes(StandardCharsets.UTF_8)
    );

    /**
     * Maps incoming HTTP GET requests for token authentication generation profiles.
     * Injects the native HTTP Authorization header directly via the RequestHeader annotation mechanism.
     *
     * @param authHeader Raw HTTP Basic authentication string containing credential tokens.
     * @return Map collection structure containing the generated access token payload.
     */
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - Initializing authentication pipeline processing sequence");
        LOGGER.debug("Extracted incoming Authorization request header: {}", authHeader);

        String username = getUser(authHeader);
        String token = generateJwt(username);

        Map<String, String> responsePayload = new HashMap<>();
        responsePayload.put("token", token);

        LOGGER.info("END - Token payload compilation completed successfully");
        return responsePayload;
    }

    /**
     * Decodes the standard incoming HTTP Basic Authentication credential wrapper text block.
     * Removes the transmission prefix and performs manual parsing of the payload structure.
     *
     * @param authHeader Raw input Authorization header string content.
     * @return Deciphered target identity username coordinate string.
     */
    private String getUser(String authHeader) {
        LOGGER.info("START - Executing Base64 credential intercept decoding");

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String clearTextCredentials = new String(decodedBytes, StandardCharsets.UTF_8);
        String username = clearTextCredentials.split(":")[0];

        LOGGER.debug("Decoded target identity context username: {}", username);
        LOGGER.info("END - Credential decoding sequence successfully finalized");
        return username;
    }

    /**
     * Formulates a highly compact JSON Web Token signature instance using target parameters.
     * Configures token lifecycle properties, expiration constraints, and cryptography profiles.
     *
     * @param user Authenticated user principal string identity.
     * @return Compacted, web-safe cryptographic token string signature.
     */
    private String generateJwt(String user) {
        LOGGER.info("START - Instantiating cryptographic token generation sequences");

        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();

        LOGGER.debug("Generated compact JSON Web Token value: {}", token);
        LOGGER.info("END - Token creation lifecycle routines finished");
        return token;
    }
}