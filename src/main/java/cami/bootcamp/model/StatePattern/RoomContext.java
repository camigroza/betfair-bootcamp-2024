package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;

public class RoomContext {

    private RoomState currentState;
    private final Room room;

    public RoomContext(Room room) {
        this.room = room;
        setStateBasedOnRoom(room.getState());
    }

    public void setState(RoomState state) {
        this.currentState = state;
    }

    private void setStateBasedOnRoom(String state) {
        switch (state) {
            case "available":
                setState(new AvailableState());
                break;
            case "reserved":
                setState(new ReservedState());
                break;
            case "checked-in":
                setState(new CheckedInState());
                break;
            case "checked-out":
                setState(new CheckedOutState());
                break;
            default:
                throw new IllegalArgumentException("Invalid state: " + state);
        }
    }

    public void reserve() {
        currentState.reserve(room);
    }

    public void checkIn() {
        currentState.checkIn(room);
    }

    public void checkOut() {
        currentState.checkOut(room);
    }

    public void makeAvailable() {
        currentState.makeAvailable(room);
    }
}
