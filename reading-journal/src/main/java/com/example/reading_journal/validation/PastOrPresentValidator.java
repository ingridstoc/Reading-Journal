/**
 * Clasă validator pentru verificarea dacă o dată este în trecut sau prezent.
 * Această clasă implementează validarea pentru adnotarea personalizată
 * {@link PastOrPresent}, asigurându-se că valoarea introdusă este fie nulă,
 * fie nu depășește data curentă.
 * @author Stochirlea Ingrid
 * @version 28 Decembrie 2024
 */

package com.example.reading_journal.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class PastOrPresentValidator implements ConstraintValidator<PastOrPresent, Date> {
    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        return value == null || !value.after(new Date());
    }
}
