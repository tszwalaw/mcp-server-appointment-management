package com.ai.mcp_server_appointment_management.helper.impl;

import com.ai.mcp_server_appointment_management.helper.TokenHelper;
import com.ai.mcp_server_appointment_management.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TokenHelperImpl implements TokenHelper {

    private final TokenRepository tokenRepository;

    @Override
    public String generateNewToken(String userId) {
        String newToken = UUID.randomUUID().toString();
        tokenRepository.insertOrUpdateToken(newToken, userId, OffsetDateTime.now());
        return newToken;
    }
}
