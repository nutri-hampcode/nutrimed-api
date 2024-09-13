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

    @Column(name="activate", nullable = false)
    private Boolean activate_appointment;

    /*
    @OnetoOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_doctor"))
    private Doctor doctor;

    @OnetoOne
    @JoinColumn(name = "id_history", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_history"))
    private History history;

    @OnetoOne
    @JoinColumn(name = "id_date", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_date"))
    private Availability id_date;

    @OnetoOne
    @JoinColumn(name = "id_time", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_time"))
    private Availability id_time;*/

}

