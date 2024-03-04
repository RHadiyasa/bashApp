package com.budimind.bashapp.entity;

import com.budimind.bashapp.model.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @Id
    private String id;
    private String transactionNumber;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    private String destinationAddress;
    private BigInteger subTotal;
    private BigInteger shippingCost;
    private BigInteger totalTransaction;

    @JoinColumn
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTime;

}
