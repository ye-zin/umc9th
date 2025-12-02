package com.example.umc9th.global.validator;

import com.example.umc9th.global.annotiation.ValidPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // null이면 기본 1로 처리
        if(value == null) return true;
        return value >= 1;
    }
}