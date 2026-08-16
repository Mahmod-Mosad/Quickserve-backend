package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.MenuItemOptionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemOptionGroupRepository extends JpaRepository<MenuItemOptionGroup, Long>
{
}
