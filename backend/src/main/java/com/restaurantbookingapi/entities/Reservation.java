package com.restaurantbookingapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name="reservations"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
        @Id
        @SequenceGenerator(
                name="reservation_sequence",
                sequenceName = "reservation_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "reservation_sequence"
        )
        @Column(
                name="id",
                updatable = false
        )
        private Long id;

        @Column(
                name="locator",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String locator;

        @Column(
                name="turn",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String turn;

        @Column(
                name="person",
                nullable = false
        )
        private Long person;

        @Column(
                name="date",
                nullable = false,
                columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
        )
        private LocalDateTime date;

        @ManyToOne
        @JoinColumn(
                name="restaurant_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "restaurant_reservation_fk"
                )
        )
        private Restaurant restaurant;
}
