package br.com.digitalBank.dto;

import br.com.digitalBank.domain.Address;
import br.com.digitalBank.domain.Client;
import br.com.digitalBank.service.annotation.ZipcodeValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ZipcodeValidation
public class AddressDto {

    @NotNull(message = "Zipcode may not be null")
    private String zipcode;

    @NotNull(message = "Street may not be null")
    private String street;

    @NotNull(message = "Neighborhood may not be null")
    private String neighborhood;

    @NotNull(message = "Complement may not be null")
    private String complement;

    @NotNull(message = "City may not be null")
    private String city;

    @NotNull(message = "State may not be null")
    private String state;

    @NotNull(message = "ClientId may not be null")
    private Long clientId;

    public Address fromEntity() {
        Client client = new Client(clientId);
        return new Address(null, getZipcode(), getStreet(), getNeighborhood(), getComplement(), getCity(), getState(), client);
    }
}
