package ru.bibrus.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;

    @Column
    private boolean delivered;

    public Order(Recipient recipient, OrderType type) {
        this.type = type;
        this.recipient = recipient;
    }

    public Order() {

    }

}
