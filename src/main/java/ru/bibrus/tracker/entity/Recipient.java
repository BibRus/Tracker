package ru.bibrus.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipients")
public class Recipient {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany()
    private final Set<Order> orders = new HashSet<>();

    public Recipient() {

    }

    public Recipient(String name, String address, String postalCode) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
    }

}