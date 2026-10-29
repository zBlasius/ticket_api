package com.main.ticket_api.session_management.domain;

public class Room {
    private final Integer id;
    private final String name;
    private final Integer chairsCapacity;
    private final Status status;

    public Room(Integer id, String name, Integer chairsCapacity, Status status) {
        this.id = id;
        this.name = name;
        this.chairsCapacity = chairsCapacity;
        this.status = status;
    }

    public static Room create(String name, Integer chairsCapacity) {
        return new Room(null, name, chairsCapacity, Status.FREE);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getChairsCapacity() {
        return chairsCapacity;
    }

    public Status getStatus() {
        return status;
    }

    // Persisted by ordinal: only append new values, never reorder
    public enum Status {
        FREE,
        OCCUPIED,
    }
}
