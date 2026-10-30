package com.main.ticket_api.session_management.infrastructure;

import com.main.ticket_api.session_management.domain.Room;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Room") // Keeps the existing "room" table
public class RoomJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer chairsCapacity;

    private Room.Status status;

    protected RoomJpaEntity() {
    }

    private RoomJpaEntity(Integer id, String name, Integer chairsCapacity, Room.Status status) {
        this.id = id;
        this.name = name;
        this.chairsCapacity = chairsCapacity;
        this.status = status;
    }

    public static RoomJpaEntity fromDomain(Room room) {
        return new RoomJpaEntity(room.getId(), room.getName(), room.getChairsCapacity(), room.getStatus());
        // use this method in order to save information in database when necessary
    }

    public Room toDomain() {
        return new Room(id, name, chairsCapacity, status);
        // use this method to return to domain Room. Notice that RoomJpaEntity and Room are two different things?

    }
}
