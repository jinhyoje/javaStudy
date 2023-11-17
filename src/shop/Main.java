package shop;

import shop.exception.PercentageException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws PercentageException {
        // 책 인스턴스 생성
        Product book1 = new Product("0001", "자바의 정석", "남궁성", 30000, 10);
        Product book2 = new Product("0002", "혼자 공부하는 자바", "산용권", 15000, 90);
        Product book3 = new Product("0003", "혼자 공부하는 자바스크립트", "윤인성", 20000, 80);

        // 고객 인스턴스 생성
        Customer customer1 = new Customer("cust123", "홍길동", new ArrayList<>());
        customer1.updateProfile("홍길동", "abc123@aaa.com", "서울시 강남구");
        System.out.println(customer1);


        // 주문 인스턴스 생성 및 고객에게 할당
        Order order1 = new Order("ord123", customer1, new ArrayList<>(), 0, "pending");

        customer1.getOrderHistory().add(order1);

        // 주문에 책 추가 및 주문 상태 업데이트
        order1.getOrderedProducts().add(book1);
        order1.getOrderedProducts().add(book2);
        order1.getOrderedProducts().add(book3);

        book1.updateStock(-1);
        book2.updateStock(-1);
        book3.updateStock(-1);

        book1.applyDiscount(35); // 가격 할인
        order1.calculateTotalPrice(); // 총 가격 계산
        order1.confirmOrder(); // 주문 확정

        System.out.println("고객 이름: " + customer1.getName());
        printOrderHistory(customer1);
        System.out.println(order1);

        customer1.cancelOrder(order1);
        printOrderHistory(customer1);


    }



    private static void printOrderHistory(Customer customer) {
        for (Order order : customer.getOrderHistory()) {
            System.out.println("주문 번호: " + order.getId());
            System.out.println("주문 상태: " + order.getStatus());
            System.out.println("주문 총액: " + order.getTotalAmount());

            for (Product product : order.getOrderedProducts()) {
                System.out.println("책 제목: " + product.getName() + " | 저자: " + product.getDescription() + " | 가격: " + product.getPrice() + " | 재고: " + product.getStockQuantity());
            }

            System.out.println();
        }
    }
}