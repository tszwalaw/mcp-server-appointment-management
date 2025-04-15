package com.ai.mcp_server_appointment_management.helper;

public interface TokenHelper {
    String GenerateNewToken(String userId);
    Boolean ValidateToken(String userId, String token);
}
