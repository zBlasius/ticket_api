package com.main.ticket_api.session_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

interface IRoomService
{
    public Room create(Integer chairCapacity, String name);
    public List<Room> find_all();
}

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    public Room create(Integer chairCapacity, String name) {

        Boolean existent_room = roomRepository.existsByName(name);
        if(existent_room){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Room name already exists");
        }

        Room room = new Room();
        room.setStatus(Room.Status.FREE);
        room.setChairs_capacity(chairCapacity);
        room.setName(name);
        return roomRepository.save(room);
    }

    public List<Room> find_all() {
        return roomRepository.findAll();
    }

    public Room findById(Integer id) {
        return roomRepository.findAllById(id);
    }
}
