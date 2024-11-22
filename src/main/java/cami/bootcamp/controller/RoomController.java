package cami.bootcamp.controller;

import cami.bootcamp.model.DTO.RoomDto;
import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;
import cami.bootcamp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody RoomDto roomToCreate) {
        return roomService.createRoom(roomToCreate);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.getRoomById(roomId);
    }

    @ExceptionHandler(BadRoomRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExceptions(Exception exception) {
        return exception.getMessage();
    }
}
