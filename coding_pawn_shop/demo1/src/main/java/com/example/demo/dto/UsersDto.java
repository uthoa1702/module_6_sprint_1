package com.example.demo.dto;

import com.example.back_end.model.Roles;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsersDto implements Validator {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 8,max = 20)
    private String password;
    private Integer verificationCode;
    private Roles roles;

    public UsersDto() {
    }

    public UsersDto(Long id, String username, String password, Integer verificationCode, Roles roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.verificationCode = verificationCode;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
