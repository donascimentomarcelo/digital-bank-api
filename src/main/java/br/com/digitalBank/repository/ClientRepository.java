package br.com.digitalBank.repository;

import br.com.digitalBank.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(final String email);

    Client findByCpf(final String cpf);
}
