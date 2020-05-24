package ru.kpfu.itis.shareholdersimulator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BetFormDto {
    private double amount;
    private UUID betTypeId;
}
