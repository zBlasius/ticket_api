package com.main.ticket_api.session_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(path = "/add")
    public @ResponseBody CreateRoomResponseDTO addNewRoom(@RequestBody CreateRoomRequestDTO request) {
        Room room = roomService.create(request.getChairCapacity(), request.getName());
        return new CreateRoomResponseDTO(room);
    }

    @GetMapping(path ="/find_all")
    public @ResponseBody List<Room> findAll() {
        return roomService.find_all();
    }

    @GetMapping(path ="/find_by_id")
    public @ResponseBody Room findById(@RequestParam Integer id) {
        return roomService.findById(id);
    }
}
