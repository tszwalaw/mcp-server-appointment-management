package com.ai.mcp_server_appointment_management.helper;

import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;
import com.ai.mcp_server_appointment_management.entity.User;

import java.util.Optional;

public interface UserHelper {
    Optional<User> VerifyUser(VerifyUserDTO verifyUserDTO);
}
