package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_history", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_history"))
    private History history;

    @OneToOne
    @JoinColumn(name = "id_availability", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_date"))
    private Availability id_availability;

}