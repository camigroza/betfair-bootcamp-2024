package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;

public class CheckedOutState implements RoomState {
    @Override
    public void reserve(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Room is being prepared and cannot be reserved yet.");
    }

    @Override
    public void checkIn(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Cannot check into a room that is checked out and being prepared.");
    }

    @Override
    public void checkOut(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Room is already checked out.");
    }

    @Override
    public void makeAvailable(Room room) {
        room.setState("available");
        System.out.println("Room preparation is complete. Room is now available for booking.");
    }
}
