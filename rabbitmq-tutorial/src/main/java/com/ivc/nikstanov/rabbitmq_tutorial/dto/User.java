package com.ivc.nikstanov.rabbitmq_tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
