package br.com.digitalBank.service.validation;

import br.com.digitalBank.constants.Constants;
import br.com.digitalBank.controller.exception.FieldMessage;
import br.com.digitalBank.dto.ClientDto;
import br.com.digitalBank.service.annotation.DateOfBirthValidation;
import br.com.digitalBank.util.Util;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthValidation, ClientDto> {
    @Override
    public void initialize(DateOfBirthValidation constraintAnnotation) {

    }

    @SneakyThrows
    @Override
    public boolean isValid(final ClientDto dto, final ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (dto.getDateOfBirth() == null) {
            return false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);

        Calendar dateOfBirth = Calendar.getInstance();

        dateOfBirth.setTime(new SimpleDateFormat(Constants.DATE_FORMAT).parse(formatter.format(dto.getDateOfBirth())));

        dateOfBirth.add(Calendar.YEAR, Constants.LIMIT_AGE);

        Calendar today = Calendar.getInstance();

        if(dateOfBirth.after(today)){
            list.add(new FieldMessage(Constants.DATEOFBIRTH, Constants.DATEOFBIRTH_UNAVALIBLE));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
