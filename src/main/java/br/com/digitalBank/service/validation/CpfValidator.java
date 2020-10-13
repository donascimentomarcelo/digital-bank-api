package br.com.digitalBank.service.validation;

import br.com.digitalBank.constants.Constants;
import br.com.digitalBank.controller.exception.FieldMessage;
import br.com.digitalBank.domain.Client;
import br.com.digitalBank.dto.ClientDto;
import br.com.digitalBank.service.ClientService;
import br.com.digitalBank.service.annotation.CpfValidation;
import br.com.digitalBank.util.CpfUtil;
import br.com.digitalBank.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CpfValidator implements ConstraintValidator<CpfValidation, ClientDto> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(CpfValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(final ClientDto dto, final ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        checkCpfFormat(dto, list);

        checkIfCpfIsAvailable(dto, list);

        Util.addInContext(context, list);

        return list.isEmpty();
    }

    private void checkIfCpfIsAvailable(final ClientDto dto, final List<FieldMessage> list) {
        Client client = clientService.findByCpf(dto.getCpf());

        if (client != null) {
            list.add(new FieldMessage(Constants.CPF, Constants.CPF_UNAVALIBLE));
        }
    }

    private void checkCpfFormat(final ClientDto dto, final List<FieldMessage> list) {
        if (!CpfUtil.isValidCPF(dto.getCpf())) {
            list.add(new FieldMessage(Constants.CPF, Constants.CPF_INVALID));
        }
    }


}
