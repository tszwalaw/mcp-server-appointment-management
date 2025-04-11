package com.ai.mcp_server_appointment_management.repository;

import com.ai.mcp_server_appointment_management.dto.request.VerifyUserDTO;
import com.ai.mcp_server_appointment_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE " +
            "u.name = :#{#dto.name} AND " +
            "u.email = :#{#dto.email} AND " +
            "u.phoneNumber = :#{#dto.phoneNumber}")
    Optional<User> findByVerifyUserDTO(@Param("dto") VerifyUserDTO dto);
}
