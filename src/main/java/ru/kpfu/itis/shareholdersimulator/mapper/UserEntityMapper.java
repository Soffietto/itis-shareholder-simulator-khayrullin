package ru.kpfu.itis.shareholdersimulator.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import ru.kpfu.itis.shareholdersimulator.dto.RegisterDto;
import ru.kpfu.itis.shareholdersimulator.entity.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {Argon2PasswordEncoder.class})
public interface UserEntityMapper {

    @Mapping(target = "password", expression = "java(new Argon2PasswordEncoder().encode(registerDto.getPassword()).toCharArray())")
    User toEntity(RegisterDto registerDto);
}
