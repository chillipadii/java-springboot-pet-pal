package sg.com.petpal.petpal.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotBlankIfPresentValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlankIfPresentValidaton {
    String message() default "Field must not be blank or null if present.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}