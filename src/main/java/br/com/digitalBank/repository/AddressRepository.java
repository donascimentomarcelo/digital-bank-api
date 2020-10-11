package br.com.digitalBank.repository;

import br.com.digitalBank.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
