package com.example.sampleapp.service;

import java.util.List;

import com.example.sampleapp.model.FinancePO;

public interface FinanceService {

	FinancePO getRecord(Long id);

	List<FinancePO> getBySector(String sector);

	FinancePO saveRecord(FinancePO financePO);

	List<FinancePO> getAll();

}
