package com.ai.mcp_server_appointment_management.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class BookAppointmentDTO {
    String userId;
    String token;
    OffsetDateTime appointmentTime;
}
