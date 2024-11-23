package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;
import cami.bootcamp.model.exception.BadRoomRequestException;

public class RoomContext {

    private RoomState currentState;
    private final Room room;

    public RoomContext(Room room) throws BadRoomRequestException {
        this.room = room;
        setStateBasedOnRoom(room.getState());
    }

    public void setState(RoomState state) {
        this.currentState = state;
    }

    private void setStateBasedOnRoom(String state) throws BadRoomRequestException {
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
                throw new BadRoomRequestException("Invalid state: " + state);
        }
    }

    public void reserve() throws BadRoomRequestException {
        currentState.reserve(room);
    }

    public void checkIn() throws BadRoomRequestException {
        currentState.checkIn(room);
    }

    public void checkOut() throws BadRoomRequestException {
        currentState.checkOut(room);
    }

    public void makeAvailable() throws BadRoomRequestException {
        currentState.makeAvailable(room);
    }
}
