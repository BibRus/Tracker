package ru.bibrus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bibrus.tracker.entity.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<Long, OrderHistory> {

}