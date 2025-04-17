package com.ai.mcp_server_appointment_management.service.impl;

import com.ai.mcp_server_appointment_management.constant.message.MessageConstant;
import com.ai.mcp_server_appointment_management.dto.request.BookAppointmentDTO;
import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;
import com.ai.mcp_server_appointment_management.entity.User;
import com.ai.mcp_server_appointment_management.helper.impl.AppointmentHelperImpl;
import com.ai.mcp_server_appointment_management.helper.impl.TokenHelperImpl;
import com.ai.mcp_server_appointment_management.helper.impl.UserHelperImpl;
import com.ai.mcp_server_appointment_management.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final UserHelperImpl userHelper;
    private final TokenHelperImpl tokenHelper;
    private final AppointmentHelperImpl appointmentHelper;

    @Tool(name = "VerifyAndGetAccessToken", description = "Verify user information and return access token valid for 24 hours which used for managing appointment")
    @Override
    public String VerifyAndGetAccessToken(VerifyUserDTO verifyUserDTO) {
        Optional<User> user = userHelper.VerifyUser(verifyUserDTO);
        if(user.isEmpty()){
           throw new RuntimeException(MessageConstant.ERROR_INVALID_CREDENTIALS);
        }
        String userId =  user.get().getId();
        return tokenHelper.GenerateNewToken(userId);
    }

    @Tool(name = "CreateNewAppointment", description = "Create new appointment for user by using the access token")
    @Override
    public String CreateNewAppointment(BookAppointmentDTO bookAppointmentDTO) {
        if(bookAppointmentDTO == null || !tokenHelper.ValidateToken(bookAppointmentDTO.getUserId(), bookAppointmentDTO.getToken())) {
            return MessageConstant.ERROR_INVALID_TOKEN;
        }
        return appointmentHelper.BookAppointment(bookAppointmentDTO);
    }

}
