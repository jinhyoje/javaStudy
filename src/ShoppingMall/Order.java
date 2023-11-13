package ShoppingMall;

import ShoppingMall.Customer;
import ShoppingMall.Product;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String id;
    private ArrayList<Product> orderedProducts;
    private String status;
    private double totalAmount;
    private Customer customer;
    private Date orderDate;

    public String getId() {
        return id;
    }

    public ArrayList<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Product> getOrderProducts() {
        return orderedProducts;
    }


    public Order(String orderId, Customer customer, ArrayList<Product> orderedProducts, double totalAmount, String status) {
        this.id = orderId;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    public void calculateTotalPrice() {
        this.totalAmount = 0;
        for (Product product : orderedProducts) {
            this.totalAmount += product.getPrice();
        }
    }

    public void confirmOrder() {
        status = "confirmed";
    }





}
