package com.example.be.entity;

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

@Entity
@Table(name = "combo_detail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComboDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_combo", referencedColumnName = "id")
    private Combo combo;

    @ManyToOne
    @JoinColumn(name = "id_snacks", referencedColumnName = "id")
    private Snacks snacks;

    @Column(name = "quantity")
    private Integer quantity;
}
