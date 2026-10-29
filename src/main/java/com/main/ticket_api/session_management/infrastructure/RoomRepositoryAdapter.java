package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.application.RoomRepository;
import com.main.ticket_api.session_management.domain.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryAdapter implements RoomRepository {
    private final RoomJpaRepository roomJpaRepository;

    RoomRepositoryAdapter(RoomJpaRepository roomJpaRepository) {
        this.roomJpaRepository = roomJpaRepository;
    }

    @Override
    public Room save(Room room) {
        return roomJpaRepository.save(RoomJpaEntity.fromDomain(room)).toDomain();
    }

    @Override
    public List<Room> findAll() {
        return roomJpaRepository.findAll().stream()
                .map(RoomJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomJpaRepository.findById(id).map(RoomJpaEntity::toDomain);
    }

    @Override
    public boolean existsByName(String name) {
        return roomJpaRepository.existsByName(name);
    }
}
