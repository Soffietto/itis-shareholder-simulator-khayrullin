package ru.kpfu.itis.shareholdersimulator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.kpfu.itis.shareholdersimulator.dto.BetTypeViewDto;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BetTypeEntityMapper {

    List<BetTypeViewDto> toDto(List<BetType> betTypes);
}
