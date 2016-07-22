package com.mikesoft.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.mikesoft.entity.PickupOrder;
import com.mikesoft.service.PickupOrderService;

@ManagedBean
@ViewScoped
public class PickupOrderServiceController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * inject helloSpringService Bean (spring)
	 */
	
	@ManagedProperty("#{pickupOrderService}")
	private PickupOrderService pickupOrderService;

	public PickupOrderService getPickupOrderService() {
		return pickupOrderService;
	}

	public void setPickupOrderService(PickupOrderService pickupOrderService) {
		this.pickupOrderService = pickupOrderService;
	}
	
	private List<PickupOrder> pickupOrderlist;
	
	private PickupOrder pickupOrder = new PickupOrder();
	
	public PickupOrder getPickupOrder() {
		return pickupOrder;
	}

	public void setPickupOrder(PickupOrder pickupOrder) {
		this.pickupOrder = pickupOrder;
	}

	@PostConstruct
	public void loadPikcupOrderlist(){
		
		setPickupOrderlist(pickupOrderService.findAll());
		
	}

	public List<PickupOrder> getPickupOrderlist() {
		return pickupOrderlist;
	}

	public void setPickupOrderlist(List<PickupOrder> pickupOrderlist) {
		this.pickupOrderlist = pickupOrderlist;
	}
	
	public String reinit(){
		pickupOrder= new PickupOrder();
		return null;
	}
	
	//Save order when user clicks save button
	public void addPickupOrder(){
		pickupOrderService.save(pickupOrder);
		reinit();
		setPickupOrderlist(pickupOrderService.findAll());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Order Saved!",null)) ;
	}
	//remove an order when user clicks remove button
	public void remove(PickupOrder anOrder){
		pickupOrderService.remove(anOrder);
		setPickupOrderlist(pickupOrderService.findAll());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Order removed!",null)) ;
	}
	public void addContactName(String contactN){
		pickupOrder.getContactName().add(contactN);
		
	}
}
