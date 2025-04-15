package com.ai.mcp_server_appointment_management.helper.impl;

import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;
import com.ai.mcp_server_appointment_management.entity.User;
import com.ai.mcp_server_appointment_management.helper.UserHelper;
import com.ai.mcp_server_appointment_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserHelperImpl implements UserHelper {

    private final UserRepository userRepository;

    @Override
    public Optional<User> VerifyUser(VerifyUserDTO verifyUserDTO) {
        return userRepository.FindByVerifyUserDTO(verifyUserDTO);
    }
}
