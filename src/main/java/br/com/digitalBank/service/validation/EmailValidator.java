package br.com.digitalBank.service.validation;

import br.com.digitalBank.constants.Constants;
import br.com.digitalBank.controller.exception.FieldMessage;
import br.com.digitalBank.domain.Client;
import br.com.digitalBank.dto.ClientDto;
import br.com.digitalBank.service.ClientService;
import br.com.digitalBank.service.annotation.EmailValidation;
import br.com.digitalBank.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator implements ConstraintValidator<EmailValidation, ClientDto> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(EmailValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(final ClientDto dto, final ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Client client = clientService.findByEmail(dto.getEmail());

        if(client != null) {
            list.add(new FieldMessage(Constants.EMAIL, Constants.EMAIL_UNAVALIBLE));
        }

        Util.addInContext(context, list);

        return list.isEmpty();
    }
}
