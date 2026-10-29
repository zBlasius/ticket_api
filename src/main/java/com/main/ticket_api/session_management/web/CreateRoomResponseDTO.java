package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.domain.Room;

public class CreateRoomResponseDTO {
    private final Integer room_id;
    private final Room.Status status;
    private final Integer chairCapacity;

    public enum Status {
        FREE,
        OCCUPIED,
    }

    public CreateRoomResponseDTO(Room room) {
        this.room_id = room.getId();
        this.status = room.getStatus();
        this.chairCapacity = room.getChairsCapacity();
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public Room.Status getStatus() {
        return status;
    }

    public Integer getChairCapacity() {
        return chairCapacity;
    }
}