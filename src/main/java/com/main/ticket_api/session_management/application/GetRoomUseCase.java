package com.main.ticket_api.session_management.application;

import com.main.ticket_api.session_management.domain.Room;
import com.main.ticket_api.session_management.domain.RoomNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetRoomUseCase {
    private final RoomRepository roomRepository;

    public GetRoomUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room execute(Integer roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
    }
}
