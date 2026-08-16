package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.MenuItemOptionValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemOptionValueRepository extends JpaRepository<MenuItemOptionValue, Long> {

}
