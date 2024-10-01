package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_SUPPORT_REQUEST")
public class UserSupportRequest { //Возможно необходимо будет убрать, пока оставлю на всякий случай

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Lob
    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATE_TIME")
    private Timestamp dateTime;

    @OneToMany
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private List<Account> accountId; //TODO: вроде лист небезопасен, но это не точно

};
