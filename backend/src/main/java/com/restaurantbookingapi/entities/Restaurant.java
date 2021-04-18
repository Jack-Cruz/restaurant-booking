package com.restaurantbookingapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="restaurants",
        uniqueConstraints = {
                @UniqueConstraint(name="restaurant_name_unique",
                        columnNames = "name")
        }

)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @SequenceGenerator(
            name="restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
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

    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name="address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Column(
            name="image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String image;

    @OneToMany(
            mappedBy = "restaurant",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Reservation> reservations  = new ArrayList<>();

    @OneToMany(
            mappedBy = "restaurant",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Turn> turns = new ArrayList<>();
}
