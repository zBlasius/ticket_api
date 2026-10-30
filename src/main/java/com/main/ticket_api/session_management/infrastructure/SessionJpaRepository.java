package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.application.SessionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJpaRepository extends JpaRepository<SessionRepository, Integer> {
}
