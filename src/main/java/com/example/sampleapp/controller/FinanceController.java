package com.example.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampleapp.constant.AppConstants;
import com.example.sampleapp.model.FinancePO;
import com.example.sampleapp.service.FinanceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = AppConstants.BASE_URL)
public class FinanceController {
	
	@Autowired
	private FinanceService financeService;
		
	@GetMapping("/{financeId}")
	public ResponseEntity<FinancePO> getData(@PathVariable(name = "financeId") Long id) {
		log.info("FinanceController::getData call for {}", id);
		
		FinancePO financePO = financeService.getRecord(id);
		
		return new ResponseEntity<>(financePO, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<FinancePO>> getDatas(@RequestParam(name = "sector") String sector) {
		log.info("FinanceController::getData call for {}", sector);
		
		List<FinancePO> financePOs = financeService.getBySector(sector);
		
		return new ResponseEntity<>(financePOs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FinancePO> saveData(@RequestBody FinancePO financePO) {
		log.info("FinanceController::saveData call for {}", financePO);
		
		FinancePO responseFinancePO = financeService.saveRecord(financePO);
		
		return new ResponseEntity<>(responseFinancePO, HttpStatus.OK);
	}

}
