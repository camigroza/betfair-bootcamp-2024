package cami.bootcamp.model.DTO;

import jakarta.validation.constraints.*;

public record RoomDto(
        @Null
        Long id,
        @NotBlank
        String type,
        @Null
        String state) {
}
