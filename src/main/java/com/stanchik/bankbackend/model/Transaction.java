package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.security.Timestamp;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID_FROM", referencedColumnName = "ID", nullable = false)
    private Account accIdFrom;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID_TO", referencedColumnName = "ID", nullable = false)
    private Account accIdTo;

    @Column(name = "AMOUNT", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "DATE_TIME", nullable = false)
    private Timestamp dateTime;

};
