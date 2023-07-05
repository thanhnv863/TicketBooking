package com.example.be.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

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
    private Integer ageLimit;

    @Column(name = "time")
    private Time time;

    @Column(name = "status")
    private Integer status;

}
