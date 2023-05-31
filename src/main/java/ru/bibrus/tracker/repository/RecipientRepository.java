package ru.bibrus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bibrus.tracker.entity.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}