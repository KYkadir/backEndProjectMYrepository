package com.project.schoolmanagment.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.schoolmanagment.entity.concretes.UserRole;
import com.project.schoolmanagment.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@MappedSuperclass     // DB de user tablosu olusmadan bu sinifin anac sinif olarak kullanilmasini sagliyor
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder         //Alt siniflarin User sinifinin builder ozelliklerini kullanabilmesine izin verir
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String ssn;
    private String name;
    private String surname;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String birthPlace;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // hassas veri oldugu icin okuma islemlerinde kullanilmasin
    private String password;
    @Column(unique = true)
    private String phoneNumber;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;
    private Gender gender;



}
