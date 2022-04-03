package com.ar.session.Aang.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CharacterPayload {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "nation is required")
    private String nation;

    @NotNull(message = "DOB is required")
    private LocalDate dayBorn;
}
