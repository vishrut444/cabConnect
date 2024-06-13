package com.example.CabConnect.model;

import com.example.CabConnect.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")//to change table name in DB
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true,nullable = false)//to make sure the email us unique and not null
    private String emailId;

    @Enumerated(EnumType.STRING) //to store gender as string in db
    private Gender gender;
}
