package com.mahmoud.quickserve.repository;

import com.mahmoud.quickserve.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
