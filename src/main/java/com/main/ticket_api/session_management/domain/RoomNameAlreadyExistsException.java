package com.main.ticket_api.session_management.domain;

public class RoomNameAlreadyExistsException extends RuntimeException {
    public RoomNameAlreadyExistsException(String name) {
        super("Room name '" + name + "' already exists");
    }
}
