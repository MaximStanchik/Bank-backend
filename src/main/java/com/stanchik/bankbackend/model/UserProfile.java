package com.stanchik.bankbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id; //TODO: возможно стоит придумать как какое-нибудь другое значение тут будет

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false) //TODO: тут внимательно перепроверить
    private User userId;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "MIDDLE_NAME", length = 50)
    private String middleName;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

};
