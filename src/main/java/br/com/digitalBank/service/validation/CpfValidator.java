package br.com.digitalBank.service.validation;

import br.com.digitalBank.constants.Constants;
import br.com.digitalBank.controller.exception.FieldMessage;
import br.com.digitalBank.dto.ClientDto;
import br.com.digitalBank.service.CpfValidation;
import br.com.digitalBank.utils.CpfUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CpfValidator implements ConstraintValidator<CpfValidation, ClientDto> {

    @Override
    public void initialize(CpfValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClientDto dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (!CpfUtil.isValidCPF(dto.getCpf())) {
            list.add(new FieldMessage(Constants.CPF, Constants.INVALID_CPF));
        }

        list.stream()
                .forEach(item -> {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(item.getMessage())
                            .addPropertyNode(item.getFieldName())
                            .addConstraintViolation();
                });

        return list.isEmpty();
    }
}
