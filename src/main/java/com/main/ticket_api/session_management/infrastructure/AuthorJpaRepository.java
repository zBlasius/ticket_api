package com.main.ticket_api.session_management.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

interface AuthorJpaRepository extends JpaRepository<AuthorJpaEntity, Integer> {
}
