package com.main.ticket_api.session_management.web;

import com.main.ticket_api.session_management.application.CreateRoomUseCase;
import com.main.ticket_api.session_management.application.GetRoomUseCase;
import com.main.ticket_api.session_management.application.ListRoomsUseCase;
import com.main.ticket_api.session_management.domain.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/room")
public class RoomController {
    private final CreateRoomUseCase createRoomUseCase; // O que é um final?
    private final ListRoomsUseCase listRoomsUseCase;
    private final GetRoomUseCase getRoomUseCase;

    public RoomController(CreateRoomUseCase createRoomUseCase, ListRoomsUseCase listRoomsUseCase, GetRoomUseCase getRoomUseCase) {
        this.createRoomUseCase = createRoomUseCase;
        this.listRoomsUseCase = listRoomsUseCase;
        this.getRoomUseCase = getRoomUseCase;
    }

    @PostMapping(path = "/add")
    public @ResponseBody CreateRoomResponseDTO addNewRoom(@RequestBody CreateRoomRequestDTO request) {
        Room room = createRoomUseCase.execute(request.getName(), request.getChairCapacity());
        return new CreateRoomResponseDTO(room);
    }

    @GetMapping(path = "/find_all")
    public @ResponseBody List<RoomResponseDTO> findAll() {
        return listRoomsUseCase.execute().stream()
                .map(RoomResponseDTO::from)
                .toList();
    }

    @GetMapping(path = "/find_by_id")
    public @ResponseBody RoomResponseDTO findById(@RequestParam Integer id) {
        return RoomResponseDTO.from(getRoomUseCase.execute(id)); // O que esse "from" significa? Pra que serve e por que está aqui?
    }
}
