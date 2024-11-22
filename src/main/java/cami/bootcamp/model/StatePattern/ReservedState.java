package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;

public class ReservedState implements RoomState {
    @Override
    public void reserve(Room room) {
        throw new UnsupportedOperationException("Room is already reserved.");
    }

    @Override
    public void checkIn(Room room) {
        room.setState("checked-in");
        System.out.println("Guest has checked into the room.");
    }

    @Override
    public void checkOut(Room room) {
        throw new UnsupportedOperationException("Cannot check out from a reserved room. Guest needs to check in first.");
    }

    @Override
    public void makeAvailable(Room room) {
        room.setState("available");
        System.out.println("Reservation canceled. Room is now available.");
    }
}
