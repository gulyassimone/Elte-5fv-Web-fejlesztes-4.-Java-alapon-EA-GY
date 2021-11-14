package hu.elte.bankapp.configuration;

import hu.elte.bankapp.webdomain.RegisterView;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegisterView registerView = (RegisterView) obj;
        return registerView.getPassword().equals(registerView.getRePassword());
    }
}