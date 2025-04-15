package com.ai.mcp_server_appointment_management.repository;

import com.ai.mcp_server_appointment_management.entity.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO appointments (user_id, appointment_id, appointment_time, last_update) " +
            "VALUES (:userId, :appointmentId, :appointmentTime, :lastUpdate)",
            nativeQuery = true)  // Added nativeQuery=true for SQL statement
    void CreateNewAppointment(@Param("userId") String userId,
                              @Param("appointmentId") String appointmentId,
                              @Param("appointmentTime") OffsetDateTime appointmentTime,
                              @Param("lastUpdate") OffsetDateTime lastUpdate);
}
