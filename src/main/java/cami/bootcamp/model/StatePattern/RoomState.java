package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;

public interface RoomState {

    void reserve(Room room) throws BadRoomRequestException;
    void checkIn(Room room) throws BadRoomRequestException;
    void checkOut(Room room) throws BadRoomRequestException;
    void makeAvailable(Room room) throws BadRoomRequestException;
}
