package cami.bootcamp.service;

import cami.bootcamp.model.DTO.RoomDto;
import cami.bootcamp.model.Room;
import cami.bootcamp.model.StatePattern.RoomContext;
import cami.bootcamp.model.converter.RoomConverter;
import cami.bootcamp.model.exception.BadRoomRequestException;
import cami.bootcamp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room createRoom(RoomDto roomToCreate) {
        return roomRepository.save(RoomConverter.DtoToRoom(roomToCreate));
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long roomId) throws BadRoomRequestException {
        return roomRepository.findById(roomId).orElseThrow(() -> new BadRoomRequestException("Room not found"));
    }

    public Room reserveRoom(Long roomId) throws BadRoomRequestException {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new BadRoomRequestException("Room not found"));
        RoomContext context = new RoomContext(room);
        context.reserve();
        return roomRepository.save(room);
    }

    public Room checkInRoom(Long roomId) throws BadRoomRequestException {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new BadRoomRequestException("Room not found"));
        RoomContext context = new RoomContext(room);
        context.checkIn();
        return roomRepository.save(room);
    }

    public Room checkOutRoom(Long roomId) throws BadRoomRequestException {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new BadRoomRequestException("Room not found"));
        RoomContext context = new RoomContext(room);
        context.checkOut();
        return roomRepository.save(room);
    }

    public Room makeRoomAvailable(Long roomId) throws BadRoomRequestException {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new BadRoomRequestException("Room not found"));
        RoomContext context = new RoomContext(room);
        context.makeAvailable();
        return roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {
        roomRepository.findById(roomId)
                .ifPresent(roomRepository::delete);
    }
}
