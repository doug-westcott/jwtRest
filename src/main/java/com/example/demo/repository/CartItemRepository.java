package com.example.demo.repository;

import com.example.demo.model.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<Cartitem, Long> {
    List<Cartitem> findByProductid(Long id);
}