package umc.spring.validation.validator;

import umc.spring.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    private int value;

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        this.value = constraintAnnotation.value() - 1;
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page < 0) {
            context.buildConstraintViolationWithTemplate(
                    value + " 페이지는 0 이상의 값이어야 합니다."
            ).addConstraintViolation();
            return false;
        }
        return true;
    }
}