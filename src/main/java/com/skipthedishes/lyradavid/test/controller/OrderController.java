package com.skipthedishes.lyradavid.test.controller;

import com.skipthedishes.lyradavid.test.model.Customer;
import com.skipthedishes.lyradavid.test.model.Order;
import com.skipthedishes.lyradavid.test.model.OrderItem;
import com.skipthedishes.lyradavid.test.model.Store;
import com.skipthedishes.lyradavid.test.repository.CustomerRepository;
import com.skipthedishes.lyradavid.test.repository.OrderRepository;
import com.skipthedishes.lyradavid.test.repository.ProductRepository;
import com.skipthedishes.lyradavid.test.repository.StoreRepository;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by david on 17/03/2018.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/api/v1/order")
    public OrderDto createOrder(@Valid @RequestBody OrderDto order) {
        Order entity = new Order();

        if (order.getCustomerId() != null && order.getCustomerId() != 0) {
            Customer customer = customerRepository.getOne(order.getCustomerId());
            entity.setCustomer(customer);
        }

        Store store = storeRepository.getOne(order.getStoreId());

        entity.setDate(new Date(System.currentTimeMillis()));
        entity.setDeliveryAddress(order.getDeliveryAddress());
        entity.setStatus(order.getStatus());
        entity.setContact(order.getContact());
        entity.setStore(store);

//        entity = orderRepository.save(entity);

        for (OrderItemDto dto : order.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(dto.getQuantity());
            orderItem.setProduct(productRepository.getOne(dto.getProductId()));
            orderItem.setPrice(orderItem.getProduct().getPrice());
            orderItem.setTotal(orderItem.getPrice() * orderItem.getQuantity());
            entity.setTotal(entity.getTotal() + orderItem.getTotal());
            entity.addOrderItem(orderItem);
        }

        entity = orderRepository.save(entity);

        System.out.println(entity);

        return order;
    }

    @Data
    public static class OrderDto implements Serializable {
        private Integer id;
        private Date date;
        private Integer customerId;
        @NotBlank
        private String deliveryAddress;
        @NotBlank
        private String contact;
        @NotNull
        @Min(1)
        private Integer storeId;
        private List<OrderItemDto> orderItems = new ArrayList<>();
        private Double total;
        private String status;
        private Date lastUpdate;
    }

    @Data
    public static class OrderItemDto implements Serializable {
        private Integer id;
        private Integer orderId;
        @NotNull
        @Min(1)
        private Integer productId;
        private Double price;
        private Integer quantity;
        private Double total;
    }
}
