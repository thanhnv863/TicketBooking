package com.example.be.Entity;

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

import java.sql.Time;

@Entity
@Table(name = "chair")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_chair_type", referencedColumnName = "id")
    private ChairType chairType;

    @NotNull
    @Column(name = "status")
    private Integer status;

    @NotNull
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @NotNull
    @Column(name = "created_time")
    private Time createdTime;

    @Column(name = "updated_time")
    private Time updatedTime;
}
