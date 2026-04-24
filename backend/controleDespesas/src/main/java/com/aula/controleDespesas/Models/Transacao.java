package com.aula.controleDespesas.Models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "transacao")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(precision = 19, scale = 2)
    private BigDecimal valor;
    private String tipo;
}
