package com.zhousz.ms.validator;

import com.zhousz.ms.util.ValidateUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return ValidateUtil.isMobile(s);
        }else {
            if (ValidateUtil.isNotEmpty(s)) {
                return ValidateUtil.isMobile(s);
            }else {
                return true;
            }
        }
    }
}
