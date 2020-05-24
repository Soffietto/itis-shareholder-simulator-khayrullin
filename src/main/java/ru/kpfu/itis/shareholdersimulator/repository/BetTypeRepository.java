package ru.kpfu.itis.shareholdersimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;

import java.util.UUID;

public interface BetTypeRepository extends JpaRepository<BetType, UUID> {
}
