package com.skipthedishes.lyradavid.test.model;

/**
 * Created by david on 17/03/2018.
 */

public class OrderItem {

private Integer id;
private Integer orderId;
private Integer productId;
private Product product;
private Integer price;
private Integer quantity;
private Integer total;

public Integer getId() {
        return id;
        }

public void setId(Integer id) {
        this.id = id;
        }

public Integer getOrderId() {
        return orderId;
        }

public void setOrderId(Integer orderId) {
        this.orderId = orderId;
        }

public Integer getProductId() {
        return productId;
        }

public void setProductId(Integer productId) {
        this.productId = productId;
        }

public Product getProduct() {
        return product;
        }

public void setProduct(Product product) {
        this.product = product;
        }

public Integer getPrice() {
        return price;
        }

public void setPrice(Integer price) {
        this.price = price;
        }

public Integer getQuantity() {
        return quantity;
        }

public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        }

public Integer getTotal() {
        return total;
        }

public void setTotal(Integer total) {
        this.total = total;
        }

}

