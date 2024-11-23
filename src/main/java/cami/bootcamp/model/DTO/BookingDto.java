package cami.bootcamp.model.DTO;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record BookingDto(
        @Null
        Long id,
        @NotNull
        Long roomId,
        @FutureOrPresent
        LocalDate checkInDate,
        @Future
        LocalDate checkOutDate,
        @NotBlank
        String customerName,
        boolean breakfastIncluded,
        boolean dinnerIncluded,
        boolean spaAccess,
        boolean airportPickup) {
}
