package cami.bootcamp.controller;

import cami.bootcamp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public void createRoom() {

    }

    @GetMapping
    public void getAllRooms() {

    }

    @GetMapping("/{roomId}")
    public void getRoom(@PathVariable Long roomId) {

    }
}
