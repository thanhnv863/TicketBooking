package com.example.be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "movie")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_director", referencedColumnName = "id")
    private Directors directors;

    @Column(name = "name")
    private String name;

    @Column(name = "premiere_date")
    private Date premiere_date;

    @Column(name = "age_limit")
    private String ageLimit;

    @Column(name = "time")
    private Integer time;

    @Column(name = "status")
    private Integer status;

//    @NotNull
//    @Column(name = "created_by")
//    private String createdBy;
//
//    @Column(name = "updated_by")
//    private String updatedBy;
//
//    @NotNull
//    @Column(name = "created_time")
//    private Date createdTime;
//
//    @Column(name = "updated_time")
//    private Date updatedTime;

}
