package com.example.thi_thu;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidExpiredDate implements ConstraintValidator<ValidateExpiredDate, LocalDate> {

    @Override
    public void initialize(ValidateExpiredDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return value.isAfter(LocalDate.now());
    }



}
