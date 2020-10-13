package br.com.digitalBank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqClient")
    @SequenceGenerator(name = "seqClient", sequenceName = "seq_id_client")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String cnh;
    private Date dateOfBirth;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Address address;

    public Client(Long clientId) {
        id = clientId;
    }
}
