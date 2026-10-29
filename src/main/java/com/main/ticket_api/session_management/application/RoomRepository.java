package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Room;

import java.util.List;
import java.util.Optional;

// Port: implemented by the infrastructure layer
public interface RoomRepository {
    Room save(Room room);

    List<Room> findAll();

    Optional<Room> findById(Integer id);

    boolean existsByName(String name);
}
