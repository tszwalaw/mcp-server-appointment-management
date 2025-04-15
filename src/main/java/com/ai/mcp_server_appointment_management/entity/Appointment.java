package com.ai.mcp_server_appointment_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;

@Data
@Entity
@Getter
@Table(name = "appointments")

public class Appointment {
    @Id
    @Column(name= "user_id", nullable = false)
    private String userId;
    @Column(name = "appointment_id", nullable = false)
    private String appointmentId;
    @Column(name = "appointment_time", nullable = false)
    private OffsetDateTime appointmentTime;
    @Column(name = "last_update", nullable = false)
    private OffsetDateTime lastUpdate;
}




