package com.ai.mcp_server_appointment_management.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyUserDTO {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
}
