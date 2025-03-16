/**
 * Adnotare personalizată pentru validarea datelor în trecut sau prezent.
 * Această adnotare poate fi aplicată pe metode, câmpuri sau parametri pentru
 * a verifica dacă valoarea unei date este în trecut sau prezent. Este asociată
 * cu {@link PastOrPresentValidator} pentru implementarea logicii de validare.
 * @author Stochirlea Ingrid
 * @version 28 Decembrie 2024
 */

package com.example.reading_journal.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PastOrPresentValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PastOrPresent {
    String message() default "Data nu poate fi în viitor.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
