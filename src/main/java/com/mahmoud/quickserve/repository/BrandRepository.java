package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}