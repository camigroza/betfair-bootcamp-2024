package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;

public class AvailableState implements RoomState {
    @Override
    public void reserve(Room room) {
        room.setState("reserved");
        System.out.println("Room has been reserved.");
    }

    @Override
    public void checkIn(Room room) {
        throw new UnsupportedOperationException("Cannot check in to an available room directly.");
    }

    @Override
    public void checkOut(Room room) {
        throw new UnsupportedOperationException("Cannot check out an available room.");
    }

    @Override
    public void makeAvailable(Room room) {
        System.out.println("Room is already available.");
    }
}
