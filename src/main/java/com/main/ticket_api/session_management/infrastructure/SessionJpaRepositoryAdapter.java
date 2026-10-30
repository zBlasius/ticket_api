package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.application.SessionRepository;
import com.main.ticket_api.session_management.domain.Room;
import com.main.ticket_api.session_management.domain.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessionJpaRepositoryAdapter implements SessionRepository {

    private final SessionJpaRepository sessionJpaRepository;

    SessionJpaRepositoryAdapter(SessionJpaRepository sessionJpaRepository) {
        this.sessionJpaRepository = sessionJpaRepository;
    }

    @Override
    public List<Session> findAll() {
        return sessionJpaRepository.findAll().stream()
                .map(SessionJpaEntity::toDomain)
                .toList();
    }
}
