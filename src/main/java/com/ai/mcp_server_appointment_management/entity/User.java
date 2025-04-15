package com.ai.mcp_server_appointment_management.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    private String role;
}

