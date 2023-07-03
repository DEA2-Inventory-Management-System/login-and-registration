package com.example.login.and.registration;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class loginDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String userName;

    @Column
    private int password;

    @Column
    private String firstName;

    @Column
    private String lastName;


}
