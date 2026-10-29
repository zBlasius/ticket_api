package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRoomsUseCase {
    private final RoomRepository roomRepository;

    public ListRoomsUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> execute() {
        return roomRepository.findAll();
    }
}
