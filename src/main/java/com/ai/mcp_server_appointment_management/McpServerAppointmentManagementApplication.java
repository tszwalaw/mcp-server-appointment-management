package com.ai.mcp_server_appointment_management;

import com.ai.mcp_server_appointment_management.service.impl.AppointmentServiceImpl;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerAppointmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerAppointmentManagementApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider appointmentTools(AppointmentServiceImpl appointmentServiceImpl) {
		return  MethodToolCallbackProvider.builder().toolObjects(appointmentServiceImpl).build();
	}

}
