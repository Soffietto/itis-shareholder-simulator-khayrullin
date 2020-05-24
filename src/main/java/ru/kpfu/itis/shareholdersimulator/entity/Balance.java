package ru.kpfu.itis.shareholdersimulator.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Balance extends AbstractEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private Double amount;

    public void addAmount(Double amount) {
        this.amount += amount;
    }

    public void subtractAmount(Double amount) {
        this.amount -= amount;
    }
}
