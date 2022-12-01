package com.examenfinal.apiexamenfinal201818218.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 30, nullable = false)
    private String name;
    @Column(name = "dni",length = 8, nullable = false)
    private String dni;
    @Column(name = "horas_trabajadas", nullable = false)
    private int horasTrabajadas;
    @Column(name = "horas_extras",nullable = false)
    private int horasExtras;

}
