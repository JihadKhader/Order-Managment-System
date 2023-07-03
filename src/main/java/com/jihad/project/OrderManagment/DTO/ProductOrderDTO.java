package com.jihad.project.OrderManagment.DTO;

/**
 * Represents a Product Order Data Transfer Object (DTO) used for transferring product order data.
 */
public class ProductOrderDTO {

    private Long productId;
    private Long orderId;
    private int quantity;
    private double price;
    private double value;

    /**
     * Returns the ID of the product associated with the order.
     *
     * @return The ID of the product associated with the order.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product associated with the order.
     *
     * @param productId The ID of the product associated with the order.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Returns the ID of the order.
     *
     * @return The ID of the order.
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of the order.
     *
     * @param orderId The ID of the order.
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Returns the quantity of the product in the order.
     *
     * @return The quantity of the product in the order.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order.
     *
     * @param quantity The quantity of the product in the order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the value of the product order.
     *
     * @return The value of the product order.
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the product order.
     *
     * @param value The value of the product order.
     */
    public void setValue(double value) {
        this.value = value;
    }
}
