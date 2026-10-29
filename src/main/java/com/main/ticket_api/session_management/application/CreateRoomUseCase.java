package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Room;
import com.main.ticket_api.session_management.domain.RoomNameAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateRoomUseCase {
    private final RoomRepository roomRepository;

    public CreateRoomUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Room execute(String name, Integer chairsCapacity) {
        if (roomRepository.existsByName(name)) {
            throw new RoomNameAlreadyExistsException(name);
        }
        return roomRepository.save(Room.create(name, chairsCapacity));
    }
}
