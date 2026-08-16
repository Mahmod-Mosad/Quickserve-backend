package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.OrderItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption,Integer> {
}
