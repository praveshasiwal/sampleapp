package com.example.sampleapp.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class FinancePO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String sector;
	private Integer numberOfFacilities;
	private Long numberOfCustomer;

}
