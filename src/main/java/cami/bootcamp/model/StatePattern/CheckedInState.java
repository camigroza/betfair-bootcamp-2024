package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;

public class CheckedInState implements RoomState {
    @Override
    public void reserve(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Cannot reserve a room that is already checked in.");
    }

    @Override
    public void checkIn(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Room is already checked in.");
    }

    @Override
    public void checkOut(Room room) {
        room.setState("checked-out");
        System.out.println("Guest has checked out of the room. Preparing the room for the next guest.");
    }

    @Override
    public void makeAvailable(Room room) throws BadRoomRequestException {
        throw new BadRoomRequestException("Cannot make a room available directly from checked in state. " +
                "Guest needs to check out first.");
    }
}
