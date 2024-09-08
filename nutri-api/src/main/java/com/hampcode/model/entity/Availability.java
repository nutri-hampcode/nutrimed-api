package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name="availabilities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"time", "date", "id_doctor"})})
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="time", nullable = false)
    private LocalTime time;

    @Column(name="date", nullable = false)
    private LocalDate date;

    @Column(name="reserved", nullable = false)
    private boolean reserved;

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_doctors_users"))
    private Doctor doctor;
}
