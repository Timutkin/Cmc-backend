package ru.timutkin.cmcapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "crypto", schema = "public")
public class Cryptocurrency {

    @Id
    @SequenceGenerator(name = "cryptocurrency_seq", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cryptocurrency_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private Timestamp date;

    private String name;

    private String price;

}
