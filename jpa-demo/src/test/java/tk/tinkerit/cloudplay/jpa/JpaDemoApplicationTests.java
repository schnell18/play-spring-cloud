package tk.tinkerit.cloudplay.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tk.tinkerit.cloudplay.jpa.model.*;
import tk.tinkerit.cloudplay.jpa.repository.CustomerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(profiles = "development")
class JpaDemoApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void customerTest() {
        Account account = new Account("12345");
        Customer customer = new Customer(
            "Jane",
            "Doe",
            "jane.doe@gmail.com",
            account
        );

        CreditCard creditCard = new CreditCard("1234567890", CreditCardType.VISA);
        customer.getAccount().getCreditCards().add(creditCard);

        String street1 = "1600 Pennsylvania Ave NW";
        Address address = new Address(
            street1,
            null,
            "DC",
            "Washington",
            "United States",
            "20500",
            AddressType.SHIPPING
        );
        customer.getAccount().getAddresses().add(address);

        customer = customerRepository.save(customer);
        Optional<Customer> savedCustomer = customerRepository.findById(customer.getId());
        assertTrue(savedCustomer.isPresent());
        assertNotNull(savedCustomer.get());
        assertNotNull(savedCustomer.get().getAccount());
        assertNotNull(savedCustomer.get().getCreatedAt());
        assertNotNull(savedCustomer.get().getLastModified());

        assertTrue(
            savedCustomer.get().getAccount().getAddresses()
            .stream().anyMatch(a -> a.getStreet1().equalsIgnoreCase(street1))
        );

        assertTrue(
            customerRepository.findByEmailContaining(customer.getEmail()).isPresent()
        );
    }

}
