package shop;

import java.util.ArrayList;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String shippingAddress;
    private ArrayList<Order> orderHistory;


    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public Customer(String customerId, String name, ArrayList<Order> orders) {
        this.id = customerId;
        this.name = name;
        this.orderHistory = orders;
    }


    public void placeOrder(Order order) {
        order.calculateTotalPrice();
        this.orderHistory.add(order);
    }

    public void cancelOrder(Order order) {
        for (Product product : order.getOrderedProducts()) {
            product.updateStock(1); // 제품 수량을 재고에 추가
        }
        order.setStatus("Cancelled"); // 주문 상태를 취소로 변경
    }

    public void updateProfile(String name, String email, String shippingAddress) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }


}

// 데이터와 비즈니스 로직을 분리할 필요

