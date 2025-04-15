package com.ai.mcp_server_appointment_management.helper.impl;

import com.ai.mcp_server_appointment_management.entity.Token;
import com.ai.mcp_server_appointment_management.helper.TokenHelper;
import com.ai.mcp_server_appointment_management.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TokenHelperImpl implements TokenHelper {

    private final TokenRepository tokenRepository;

    @Override
    public String GenerateNewToken(String userId) {
        String newToken = UUID.randomUUID().toString();
        tokenRepository.InsertOrUpdateToken(newToken, userId, OffsetDateTime.now().plusHours(24));
        return newToken;
    }

    @Override
    public Boolean ValidateToken(String userId, String token) {
        Optional<Token> tokenRecord = tokenRepository.ValidateToken(userId, token);
        return tokenRecord.filter(value -> !value.getExpiredTime().isBefore(OffsetDateTime.now())).isPresent();
    }
}
