package bankapp.repository.impl;

import bankapp.dto.CustomerDTO;
import bankapp.repository.MemoryRepository;

import java.util.List;

public class CustomerRepositoryImpl implements MemoryRepository<CustomerDTO> {
    private List<CustomerDTO> customers;

    public CustomerRepositoryImpl(List<CustomerDTO> list) {
        customers = list;
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        customers.add(customerDTO);

    }

    @Override
    public void update(long id, CustomerDTO customerDTO) {
        customers.stream().filter(customer -> customer.getId() == id).findFirst().ifPresent(customer -> {
            CustomerDTO.of(customerDTO.getName());
        });
    }

    @Override
    public void delete(long id) {
        customers.remove((int) id);
    }

    @Override
    public CustomerDTO findById(long id) {
        return customers.stream().filter(customerDTO -> customerDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customers;
    }
}
