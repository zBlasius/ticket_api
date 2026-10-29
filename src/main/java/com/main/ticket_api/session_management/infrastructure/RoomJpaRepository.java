package com.main.ticket_api.session_management.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

interface RoomJpaRepository extends JpaRepository<RoomJpaEntity, Integer> {

    boolean existsByName(String name);
}
