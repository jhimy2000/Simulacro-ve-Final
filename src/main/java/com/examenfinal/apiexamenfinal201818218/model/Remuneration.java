package com.examenfinal.apiexamenfinal201818218.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "remunerations")
public class Remuneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;
    @Column(name = "content",length = 255, nullable = false)
    private String content;
    @Column(name = "salary", nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,
            foreignKey = @ForeignKey(name = "FK_EMPLOYEE_ID"))
    private Employee employee;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
}
