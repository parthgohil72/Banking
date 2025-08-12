package com.ebanking.accounts.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDate createAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(updatable = false)
    private LocalDate updateAt;

    @Column(updatable = false)
    private String updatedBy;

}
