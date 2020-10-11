package br.com.digitalBank.service.validation;

import br.com.digitalBank.constants.Constants;
import br.com.digitalBank.controller.exception.FieldMessage;
import br.com.digitalBank.dto.AddressDto;
import br.com.digitalBank.service.annotation.ZipcodeValidation;
import br.com.digitalBank.util.Util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeValidator implements ConstraintValidator<ZipcodeValidation, AddressDto> {
    @Override
    public void initialize(ZipcodeValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(AddressDto dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if(!dto.getZipcode().matches(Constants.ZIPCODE_PATTERN)) {
            list.add(new FieldMessage(Constants.ZIPCODE, Constants.ZIPCODE_INVALID));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
