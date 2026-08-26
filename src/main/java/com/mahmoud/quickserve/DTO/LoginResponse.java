package com.mahmoud.quickserve.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String token;
    private String email;
    private String role;
}