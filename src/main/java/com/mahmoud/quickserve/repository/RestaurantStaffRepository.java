package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.RestaurantStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantStaffRepository extends JpaRepository<RestaurantStaff, Long> {


}
