package com.ai.mcp_server_appointment_management.service;

import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;

public interface AppointmentService {
    String VerifyAndGetAccessToken(VerifyUserDTO verifyUserDTO);
}