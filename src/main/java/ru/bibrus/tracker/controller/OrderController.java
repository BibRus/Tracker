package ru.bibrus.tracker.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.bibrus.tracker.entity.Order;
import ru.bibrus.tracker.repository.OrderRepository;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public List<Order> saveAll(@RequestBody Set<Order> orders) {
        return repository.saveAll(orders);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return repository.save(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}