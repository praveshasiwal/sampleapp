package com.example.sampleapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "finance")
public class FinanceDTO implements Serializable {

	/**
	 * generated serial Version
	 */
	private static final long serialVersionUID = -4431775939978862400L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "sector")
	private String sector;
	
	@Column(name = "number_of_facilities")
	private Integer numberOfFacilities;
	
	@Column(name = "number_of_customer")
	private Long numberOfCustomer;

//	Sector, Total exposure, Number of Facilities, Number of Customers

}
