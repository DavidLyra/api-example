package com.skipthedishes.lyradavid.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by david on 17/03/2018.
 */
@Entity
@Table(name = "order_item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Data
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double price;
    private Integer quantity;
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

}

