package com.budimind.bashapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_log")
public class TransactionLog implements Serializable {

    @Id
    private String id;

    private String logType;
    private String logMessage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @JoinColumn
    @ManyToOne
    private Transaction transactionId;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
