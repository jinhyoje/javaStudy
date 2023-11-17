package shop;

import shop.exception.PercentageException;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    public Product(String productId, String name, String description, double price, int stockQuantity) {
        this.id = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void applyDiscount(double percentage) throws PercentageException {
        if (percentage > 0 && percentage <= 100) {
            this.price -= this.price * (percentage / 100);
        } else {
            throw new PercentageException("잘못된 퍼센트입니다.");
        }
    }

}
