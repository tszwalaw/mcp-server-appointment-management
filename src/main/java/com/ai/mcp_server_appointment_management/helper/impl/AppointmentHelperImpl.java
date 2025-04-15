package com.ai.mcp_server_appointment_management.helper.impl;

import com.ai.mcp_server_appointment_management.dto.request.BookAppointmentDTO;
import com.ai.mcp_server_appointment_management.helper.AppointmentHelper;
import com.ai.mcp_server_appointment_management.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AppointmentHelperImpl implements AppointmentHelper {
    private final AppointmentRepository appointmentRepository;

    @Override
    public String BookAppointment(BookAppointmentDTO bookAppointmentDTO) {
        appointmentRepository.CreateNewAppointment(bookAppointmentDTO.getUserId(),
                UUID.randomUUID().toString(),
                bookAppointmentDTO.getAppointmentTime(),
                OffsetDateTime.now());
        return "Book Appointment succeed.";
    }
}
