package com.example.demo.repository;

import com.example.demo.model.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cartitem, Long> {
}