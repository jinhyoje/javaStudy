package bankapp.controller;

import bankapp.dto.CustomerDTO;
import bankapp.service.AccountService;
import bankapp.service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void signUp(CustomerDTO customerDTO) { // 회원가입
        CustomerDTO.of(customerDTO.getName());
        customerService.signUp(customerDTO);
        System.out.println(String.format("%s님", customerDTO.getName()));
    }

    public CustomerDTO getProfile(long id) { // 회원조회
        return customerService.getProfile(id);
    }

    public void updateProfile(long id, CustomerDTO customerDTO) {
        CustomerDTO.of(customerDTO.getName());
        customerService.editProfile(id, customerDTO);
        System.out.println(String.format("%s님, 회원정보가 수정되었습니다.", customerDTO.getName()));
    }

    public void deleteProfile(long id) {
        customerService.removeProfile(id);
        System.out.println(String.format("회원탈퇴가 완료되었습니다. %s", id));
    }

}
