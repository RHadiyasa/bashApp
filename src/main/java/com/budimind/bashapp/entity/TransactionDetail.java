package com.budimind.bashapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction_details")
public class TransactionDetail implements Serializable {

    @Id
    private String id;
    private String description;
    private Integer qty;
    private BigInteger price;
    private BigInteger subTotal;

    @JoinColumn
    @ManyToOne
    private Transaction transactionId;

    @JoinColumn
    @ManyToOne
    private Product productId;
}
