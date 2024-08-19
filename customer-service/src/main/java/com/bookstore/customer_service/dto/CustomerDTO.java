package com.bookstore.customer_service.dto;


import jakarta.validation.constraints. *;

//TODO : Validation
public record CustomerDTO(
        long id,

        @NotNull(message = "Name cannot be null")
        @NotEmpty(message = "Name cannot be empty")
        @Size(min = 1, max = 255, message = "Name length must be between 1 and 255 characters")
        String name,

        @NotNull(message = "Email cannot be null")
        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Email should be valid")
        String email,

        @NotNull(message = "Phone number cannot be null")
        @NotEmpty(message = "Phone number cannot be empty")
        @Pattern(regexp = "((\\+*)((0[ -]*)*|((91 )*))((\\d{12})+|(\\d{10})+))|\\d{5}([- ]*)\\d{6}", message = "Phone number should be valid and can include country code")
        String phoneNumber
) {

}
