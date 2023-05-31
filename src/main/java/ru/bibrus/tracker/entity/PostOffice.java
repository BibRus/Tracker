package ru.bibrus.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
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
@Table(name = "post_offices")
public class PostOffice {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

}