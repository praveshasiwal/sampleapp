package com.example.sampleapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampleapp.dao.FinanceRepository;
import com.example.sampleapp.model.FinanceDTO;
import com.example.sampleapp.model.FinancePO;
import com.example.sampleapp.service.FinanceService;
import com.example.sampleapp.util.AppUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FinanceServiceImpl implements FinanceService {

	@Autowired
	private FinanceRepository financeRepository;

	@Override
	public FinancePO getRecord(Long id) {
		log.debug("FinanceServiceImpl::getRecord, start");
		Optional<FinanceDTO> optional = financeRepository.findById(id);
		if (optional.isPresent()) {
			FinanceDTO source = optional.get();
			FinancePO financePO = AppUtils.copySourceToTarget(source, FinancePO.class);
			return financePO;
		}
		throw new RuntimeException("Record Not Found");
	}

	@Override
	public List<FinancePO> getBySector(String sector) {
		log.debug("FinanceServiceImpl::getBySector, start");
		List<FinanceDTO> financeDTOs = financeRepository.findBySector(sector);
		List<FinancePO> financePOs = new ArrayList<>();
		if (null != financeDTOs && !financeDTOs.isEmpty()) {
			for (FinanceDTO financeDTO : financeDTOs) {
				FinancePO financePO = AppUtils.copySourceToTarget(financeDTO, FinancePO.class);
				financePOs.add(financePO);
			}
			return financePOs;
		}else {
			throw new RuntimeException("No Data Found");
		}
	}

	@Override
	public FinancePO saveRecord(FinancePO financePO) {
		log.debug("FinanceServiceImpl::saveRecord, start");
		if (null != financePO) {
			FinanceDTO financeDTO = AppUtils.copySourceToTarget(financePO, FinanceDTO.class);
			FinanceDTO responseFinanceDTO = financeRepository.save(financeDTO);
			financePO = AppUtils.copySourceToTarget(responseFinanceDTO, FinancePO.class);
			return financePO;
		}else {
			log.error("Invalid Content Recived");
			throw new RuntimeException("Invalid Content Recived");
		}
	}

	@Override
	public List<FinancePO> getAll() {
		log.debug("FinanceServiceImpl::getBySector, start");
		List<FinanceDTO> financeDTOs = financeRepository.findAll();
		List<FinancePO> financePOs = new ArrayList<>();
		if (null != financeDTOs && !financeDTOs.isEmpty()) {
			for (FinanceDTO financeDTO : financeDTOs) {
				FinancePO financePO = AppUtils.copySourceToTarget(financeDTO, FinancePO.class);
				financePOs.add(financePO);
			}
			return financePOs;
		}else {
			throw new RuntimeException("No Data Found");
		}
	}
}
