package bankapp.dto;

public class CustomerDTO {

    private static Long nextId = 1L;
    private Long id;
    private String name;

    private CustomerDTO() {
    }

    public static CustomerDTO of(String name){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.id = generateNextId();
        customerDTO.name = name;
        return customerDTO;
    }

    private static synchronized Long generateNextId() { // 멀티스레딩 환경에서 안전하게 사용하기 위해 synchronized 키워드 사용
        // 다음 id를 생성하고 증가
        Long generatedId = nextId;
        nextId++;
        return generatedId;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
