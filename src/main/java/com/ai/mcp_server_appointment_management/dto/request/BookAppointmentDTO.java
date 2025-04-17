package com.ai.mcp_server_appointment_management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentDTO {
    private String userId;
    private String token;
    private String appointmentTime;

    public OffsetDateTime getAppointmentDateTime() {
        try {
            // Parse the string to LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(appointmentTime,
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            // Convert to OffsetDateTime using system default offset
            return localDateTime.atOffset(ZoneOffset.systemDefault().getRules()
                    .getOffset(localDateTime));

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid appointment time format. " +
                    "Expected format: YYYY-MM-DDThh:mm:ss", e);
        }
    }
}
