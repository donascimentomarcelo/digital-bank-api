package br.com.digitalBank.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqClient")
    @SequenceGenerator(name = "seqClient", sequenceName = "seq_id_client")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String cnh;
    private String dateOfBirth;

}
