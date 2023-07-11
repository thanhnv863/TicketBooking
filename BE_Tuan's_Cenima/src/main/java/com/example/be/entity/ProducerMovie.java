package com.example.be.entity;

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

@Entity
@Table(name = "producer_movie")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producer", referencedColumnName = "id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "id_movie", referencedColumnName = "id")
    private Movie movie;

}
