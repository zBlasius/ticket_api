package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.Room;

public record RoomResponseDTO(Integer id, String name, Integer chairs_capacity, Room.Status status) {

    public static RoomResponseDTO from(Room room) {
        return new RoomResponseDTO(room.getId(), room.getName(), room.getChairsCapacity(), room.getStatus());
    }
}
