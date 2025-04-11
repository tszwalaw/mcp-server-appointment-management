package com.ai.mcp_server_appointment_management.repository;

import com.ai.mcp_server_appointment_management.entity.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tokens (token_id, user_id, expired_time) " +
            "VALUES (:tokenId, :userId, :expiredTime) " +
            "ON CONFLICT (user_id) " +
            "DO UPDATE SET token_id = EXCLUDED.token_id, expired_time = EXCLUDED.expired_time",
            nativeQuery = true)
    void insertOrUpdateToken(@Param("tokenId") String tokenId,
                             @Param("userId") String userId,
                             @Param("expiredTime") OffsetDateTime expired_time);

    // Add finder method for user
    Optional<Token> findByUserId(String userId);
}
