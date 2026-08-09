package com.william.meu_projeto.dto;

public class LoginResponseDTO {
    private String email;

    public LoginResponseDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
