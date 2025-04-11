package com.ai.mcp_server_appointment_management.dto.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyUserDTO {
    private String name;
    private String email;
    private String phoneNumber;
}
