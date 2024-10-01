package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Credits")
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CREDIT_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private CreditType creditTypeId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private Account accountId;

    @Column(name = "AMOUNT", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

};