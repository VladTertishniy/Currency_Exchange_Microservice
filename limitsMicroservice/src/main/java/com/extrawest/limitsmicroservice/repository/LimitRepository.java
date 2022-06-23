package com.extrawest.limitsmicroservice.repository;

import com.extrawest.limitsmicroservice.model.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitRepository extends JpaRepository<Limit, Long> {
}
