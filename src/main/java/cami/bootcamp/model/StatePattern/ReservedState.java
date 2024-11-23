package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;

public class ReservedState implements RoomState {
    @Override
    public void reserve(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Room is already reserved.");
    }

    @Override
    public void checkIn(Room room) {
        room.setState("checked-in");
        System.out.println("Guest has checked into the room.");
    }

    @Override
    public void checkOut(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Cannot check out from a reserved room. Guest needs to check in first.");
    }

    @Override
    public void makeAvailable(Room room) {
        room.setState("available");
        System.out.println("Reservation canceled. Room is now available.");
    }
}
