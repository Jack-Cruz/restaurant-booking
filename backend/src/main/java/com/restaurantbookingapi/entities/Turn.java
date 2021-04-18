package com.restaurantbookingapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name="turns",
        uniqueConstraints = {
                @UniqueConstraint(name="turns_name_unique",
                        columnNames = "name")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turn {
        @Id
        @SequenceGenerator(
                name="turn_sequence",
                sequenceName = "turn_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "turn_sequence"
        )
        @Column(
                name="id",
                updatable = false
        )
        private Long id;

        @Column(
                name="name",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String name;

        @ManyToOne
        @JoinColumn(
                name="restaurant_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "restaurant_turn_fk"
                )
        )
        private Restaurant restaurant;
}
