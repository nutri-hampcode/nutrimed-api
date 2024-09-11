package com.hampcode.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="height", nullable = true)
    private Double height;

    @Column(name="weight", nullable = true)
    private Double weight;

    @Column(name="age", nullable = true)
    private Integer age;

    @Column(name="allergies", nullable = true)
    private String allergies;

    @OnetoOne
    @JoinColumn(name = "id_goal", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_goal"))
    private Goal goal;

    @OnetoOne
    @JoinColumn(name = "id_diet_type", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_id_diet_type"))
    private DietType dietType;
}
