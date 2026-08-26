package com.mahmoud.quickserve.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRegisterRequest {
    private String userName;
    private String email;
    private String password;
    private String phone;
}
