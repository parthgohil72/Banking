package com.ebanking.accounts.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Name Cannot be empty")
    @Size(min = 5, max = 20, message = "The lenght of Customer name should be minimum 5 and maximum 20")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotEmpty(message = "Phone Number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    private String number;

    AccountDTO accountDTO;
}
