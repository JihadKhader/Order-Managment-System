package com.jihad.project.OrderManagment.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A composite key class representing the ID of a product order.
 */
@SuppressWarnings("serial")
public class ProductOrderId implements Serializable {

    private Long productId;
    private Long orderId;

    /**
     * Default constructor.
     */
    public ProductOrderId() {
    }

    /**
     * Constructs a ProductOrderId with the specified product ID and order ID.
     *
     * @param productId the product ID
     * @param orderId   the order ID
     */
    public ProductOrderId(Long productId, Long orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    /**
     * Get the product ID.
     *
     * @return the product ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Set the product ID.
     *
     * @param productId the product ID to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Get the order ID.
     *
     * @return the order ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Set the order ID.
     *
     * @param orderId the order ID to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Check if this ProductOrderId is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrderId that = (ProductOrderId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(orderId, that.orderId);
    }

    /**
     * Generate the hash code for this ProductOrderId.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }
}