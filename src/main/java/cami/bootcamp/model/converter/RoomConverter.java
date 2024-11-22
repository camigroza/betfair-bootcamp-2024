package cami.bootcamp.model.converter;

import cami.bootcamp.model.DTO.RoomDto;
import cami.bootcamp.model.Room;

public class RoomConverter {

    public static Room DtoToRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.id());
        room.setType(roomDto.type());
        room.setState("available");
        return room;
    }
}
