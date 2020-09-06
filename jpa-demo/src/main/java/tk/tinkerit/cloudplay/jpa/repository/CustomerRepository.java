package tk.tinkerit.cloudplay.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tk.tinkerit.cloudplay.jpa.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Optional<Customer> findByEmailContaining(String email);
}
