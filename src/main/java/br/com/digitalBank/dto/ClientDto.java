package br.com.digitalBank.dto;

import br.com.digitalBank.service.CpfValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@CpfValidation
public class ClientDto {

    @NotNull(message = "Name may not be null")
    private String name;

    private String lastName;

    @NotNull(message = "Email may not be null")
    @Email(message = "Email format is invalid")
    private String email;

    @NotNull(message = "Cnh may not be null")
    private String cnh;

    private String dateOfBirth;

    private String cpf;
}
