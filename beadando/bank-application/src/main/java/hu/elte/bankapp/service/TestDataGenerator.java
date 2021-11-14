package hu.elte.bankapp.service;

import hu.elte.bankapp.entities.Customer;
import hu.elte.bankapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
@Component
public class TestDataGenerator {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createTestData() {
        Customer bela = createCustomer("Bela", "1234","bela@nagyonjo.hu", "0630","address", LocalDate.now());
        customerRepository.save(bela);
    }

    private Customer createCustomer(String name, String password, String email, String phoneNum, String address, LocalDate dateOfBirth) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(passwordEncoder.encode(password));
        System.out.println(customer.getPassword());
        customer.setEmail(email);
        customer.setPhoneNum(phoneNum);
        customer.setAddress(address);
        customer.setDateOfBirth(dateOfBirth);
        return customer;
    }
}
