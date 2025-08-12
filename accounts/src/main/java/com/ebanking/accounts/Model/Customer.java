package com.ebanking.accounts.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String email;

    @Column(name="mobile_number")
    private String number;
}
