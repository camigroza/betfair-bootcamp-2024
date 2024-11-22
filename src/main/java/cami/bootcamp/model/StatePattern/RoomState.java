package cami.bootcamp.model.StatePattern;

import cami.bootcamp.model.Room;

public interface RoomState {

    void reserve(Room room);
    void checkIn(Room room);
    void checkOut(Room room);
    void makeAvailable(Room room);
}
