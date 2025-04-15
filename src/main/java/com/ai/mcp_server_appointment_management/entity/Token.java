package com.ai.mcp_server_appointment_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;

@Data
@Entity
@Getter
@Table(name = "tokens")

public class Token {
    @Id
    @Column(name= "token_id", nullable = false)
    private String token;
    @Column(name= "user_id", unique = true, nullable = false)
    private String userId;
    @Column(name = "expired_time", nullable = false)
    private OffsetDateTime expiredTime;

}




