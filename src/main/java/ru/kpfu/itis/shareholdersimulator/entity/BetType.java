package ru.kpfu.itis.shareholdersimulator.entity;

import lombok.Getter;
import lombok.Setter;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetTypes;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bet_type")
public class BetType extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "bet_type")
    @Enumerated(EnumType.STRING)
    private BetTypes betType;
}
