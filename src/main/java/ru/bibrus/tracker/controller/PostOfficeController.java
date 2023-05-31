package ru.bibrus.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bibrus.tracker.entity.Order;
import ru.bibrus.tracker.entity.PostOffice;
import ru.bibrus.tracker.repository.OrderRepository;
import ru.bibrus.tracker.repository.PostOfficeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController("api/offices")
public class PostOfficeController {

    private final PostOfficeRepository officeRepository;
    private final OrderRepository orderRepository;

    public PostOfficeController(PostOfficeRepository officeRepository, OrderRepository orderRepository) {
        this.officeRepository = officeRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public List<PostOffice> saveAll(@RequestBody Set<PostOffice> offices) {
        return officeRepository.saveAll(offices);
    }

    @PostMapping
    public PostOffice save(@RequestBody PostOffice office) {
        return officeRepository.save(office);
    }

    @GetMapping
    public List<PostOffice> findAll() {
        return officeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostOffice> findById(@PathVariable long id) {
        return officeRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("{officeId}/orders/{orderId}")
    public List<Order> findOrderById(@PathVariable long officeId, @PathVariable long orderId) {
        Optional<PostOffice> office = officeRepository.findById(officeId);
        if (office.isPresent()) {
            return orderRepository.findByPostOffice(office.get());
        } else {
            return Collections.emptyList();
        }
    }

}