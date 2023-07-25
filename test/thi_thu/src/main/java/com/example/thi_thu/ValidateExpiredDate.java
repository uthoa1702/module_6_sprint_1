package com.example.thi_thu;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = ValidExpiredDate.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateExpiredDate {
    String message() default "Invalid nha";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
