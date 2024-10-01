package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PASSPORT_NUM", length = 20, nullable = false)
    private String passportNum;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

};

//TODO: все модельки сделать, потом запушить в репозиторий, потом попробовать подключиться к ораклу, потом сервисы и контроллеры. обязательно подключиться к бд.
