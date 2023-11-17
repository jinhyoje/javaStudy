package bankapp.service;

import bankapp.dto.CustomerDTO;
import bankapp.repository.MemoryRepository;

public class CustomerService {

    private final MemoryRepository<CustomerDTO> customerRepository;

    public CustomerService(MemoryRepository<CustomerDTO> customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void signUp(CustomerDTO customerDTO) {
        customerRepository.create(customerDTO);
    }

    public CustomerDTO getProfile(long id) {
        return customerRepository.findById(id);
    }

    public void editProfile(long id, CustomerDTO customerDTO) {
        CustomerDTO customerDTOById = customerRepository.findById(id);

        CustomerDTO updateCustomerDTO = CustomerDTO.of(customerDTO.getName());

        customerRepository.update(id, updateCustomerDTO);
    }

    public void removeProfile(long id) {
        customerRepository.delete(id);
    }
}
