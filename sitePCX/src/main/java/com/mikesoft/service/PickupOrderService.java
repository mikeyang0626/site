package com.mikesoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikesoft.entity.PickupOrder;
import com.mikesoft.repository.PickupOrderRepository;

@Service
public class PickupOrderService {
	
	@Autowired
	private PickupOrderRepository pickupOrderRepository;
	
	public List<PickupOrder> findAll(){
		return pickupOrderRepository.findAll();
	}
	public void save(PickupOrder pickupOrder){
		pickupOrderRepository.save(pickupOrder);
	}
	public void remove(PickupOrder pickupOrder){
		pickupOrderRepository.delete(pickupOrder);
	}
}
