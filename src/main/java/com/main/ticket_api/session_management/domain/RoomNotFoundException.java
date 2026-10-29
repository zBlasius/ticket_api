package com.main.ticket_api.session_management.domain;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Integer roomId) {
        super("Room " + roomId + " not found");
    }
}
