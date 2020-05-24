package ru.kpfu.itis.shareholdersimulator.entity;

import lombok.*;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "bet")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bet extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "bet_type_id")
    private BetType betType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "win")
    private boolean win;

    @Column(name = "actual_stock_value")
    private double actualStockValue;

    @Column(name = "bet_status")
    @Enumerated(EnumType.STRING)
    private BetStatus betStatus;
}
