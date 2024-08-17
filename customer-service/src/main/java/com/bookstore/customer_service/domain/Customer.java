package com.bookstore.customer_service.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")

public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String email;
    private String phoneNumber;
}
