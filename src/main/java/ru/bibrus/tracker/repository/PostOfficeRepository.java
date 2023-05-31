package ru.bibrus.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bibrus.tracker.entity.PostOffice;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

}