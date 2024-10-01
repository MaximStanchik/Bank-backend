package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY_EXCHANGE_RATE")
public class CurrencyExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SOURCE_CURR_ID", referencedColumnName = "ID", nullable = false)
    private Currency sourceCurrId;

    @ManyToOne
    @JoinColumn(name = "TARGET_CURR_ID", referencedColumnName = "ID", nullable = false)
    private Currency targetCurrId;

    @Column(name = "RATE", precision = 15, scale = 2, nullable = false)
    private BigDecimal rate;

    @Column(name = "DATE", nullable = false)
    private Date date;

};
