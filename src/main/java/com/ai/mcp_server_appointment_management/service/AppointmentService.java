package com.ai.mcp_server_appointment_management.service;

import com.ai.mcp_server_appointment_management.dto.request.BookAppointmentDTO;
import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public interface AppointmentService {
    String VerifyAndGetAccessToken(VerifyUserDTO verifyUserDTO);
    String CreateNewAppointment(BookAppointmentDTO bookAppointmentDTO);
}