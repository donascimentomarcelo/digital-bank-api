package br.com.digitalBank.dto;

import br.com.digitalBank.domain.Client;
import br.com.digitalBank.service.annotation.CpfValidation;
import br.com.digitalBank.service.annotation.DateOfBirthValidation;
import br.com.digitalBank.service.annotation.EmailValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@CpfValidation
@EmailValidation
@DateOfBirthValidation
public class ClientDto {

    @NotNull(message = "Name may not be null")
    private String name;

    private String lastName;

    @NotNull(message = "Email may not be null")
    @Email(message = "Email format is invalid")
    private String email;

    @NotNull(message = "Cnh may not be null")
    private String cnh;

    @NotNull(message = "Date of birth may not be null")
    private Date dateOfBirth;

    private String cpf;

    public Client fromEntity() {
        return new Client(null, name, lastName, email, cnh, dateOfBirth, cpf, null);
    }
}
