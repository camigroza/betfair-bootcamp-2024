package cami.bootcamp.controller;

import cami.bootcamp.model.DTO.RoomDto;
import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;
import cami.bootcamp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody @Validated RoomDto roomToCreate) {
        return roomService.createRoom(roomToCreate);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.getRoomById(roomId);
    }

    @DeleteMapping("/{roomId}")
    public String deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return "Room deleted successfully";
    }

    @PutMapping("/reserve/{roomId}")
    public Room reserveRoom(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.reserveRoom(roomId);
    }

    @PutMapping("/check-in/{roomId}")
    public Room checkInRoom(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.checkInRoom(roomId);
    }

    @PutMapping("/check-out/{roomId}")
    public Room checkOutRoom(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.checkOutRoom(roomId);
    }

    @PutMapping("/make-available/{roomId}")
    public Room makeRoomAvailable(@PathVariable Long roomId) throws BadRoomRequestException {
        return roomService.makeRoomAvailable(roomId);
    }

    @ExceptionHandler(BadRoomRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExceptions(Exception exception) {
        return exception.getMessage();
    }
}
