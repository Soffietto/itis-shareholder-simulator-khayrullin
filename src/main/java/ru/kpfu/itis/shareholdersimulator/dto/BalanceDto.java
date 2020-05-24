package ru.kpfu.itis.shareholdersimulator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class BalanceDto {

    private UUID id;
    private Double additionalBalance;
}
