package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;

public class CheckedOutState implements RoomState {
    @Override
    public void reserve(Room room) {
        throw new UnsupportedOperationException("Room is being prepared and cannot be reserved yet.");
    }

    @Override
    public void checkIn(Room room) {
        throw new UnsupportedOperationException("Cannot check into a room that is checked out and being prepared.");
    }

    @Override
    public void checkOut(Room room) {
        throw new UnsupportedOperationException("Room is already checked out.");
    }

    @Override
    public void makeAvailable(Room room) {
        room.setState("available");
        System.out.println("Room preparation is complete. Room is now available for booking.");
    }
}
