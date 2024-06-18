package com.ivc.nikstanov.kafkademo.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
