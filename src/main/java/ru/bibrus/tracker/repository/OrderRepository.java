package ru.bibrus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bibrus.tracker.entity.Order;
import ru.bibrus.tracker.entity.PostOffice;
import ru.bibrus.tracker.entity.Recipient;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByRecipient(Recipient recipient);

    List<Order> findByPostOffice(PostOffice office);

}