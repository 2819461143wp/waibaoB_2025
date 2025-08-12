package org.example.waibao.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String role = "user";
}