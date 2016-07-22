package com.mikesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikesoft.entity.PickupOrder;

public interface PickupOrderRepository extends JpaRepository<PickupOrder, Long>{

}
