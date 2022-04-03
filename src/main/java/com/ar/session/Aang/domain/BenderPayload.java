package com.ar.session.Aang.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class BenderPayload {

    @NotNull(message = "Id id required")
    private Integer id;

    private LocalDate deadDay;

    private String name;

    @Min(value = 1, message = "level should not be less than 1")
    @Max(value = 5, message = "level should not be greater than 5")
    private Integer level;
}
