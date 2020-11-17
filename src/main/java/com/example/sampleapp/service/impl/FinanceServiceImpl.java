package com.example.sampleapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampleapp.dao.FinanceRepository;
import com.example.sampleapp.model.FinanceDTO;
import com.example.sampleapp.model.FinancePO;
import com.example.sampleapp.service.FinanceService;

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
		FinancePO financePO = null;
		if (optional.isPresent()) {
			FinanceDTO source = optional.get();
			BeanUtils.copyProperties(source, financePO);
		}
		return financePO;
	}

	@Override
	public List<FinancePO> getBySector(String sector) {
		log.debug("FinanceServiceImpl::getBySector, start");
		List<FinanceDTO> financeDTOs = financeRepository.findBySector(sector);
		List<FinancePO> financePOs = new ArrayList<>();
		if (null != financeDTOs && financeDTOs.isEmpty()) {
			for (FinanceDTO financeDTO : financeDTOs) {
				FinancePO financePO = new FinancePO();
				BeanUtils.copyProperties(financeDTO, financePO);
				financePOs.add(financePO);
			}
		}
		return financePOs;
	}

	@Override
	public FinancePO saveRecord(FinancePO financePO) {
		log.debug("FinanceServiceImpl::saveRecord, start");
		if (null != financePO) {
			FinanceDTO financeDTO = new FinanceDTO();
			BeanUtils.copyProperties(financePO, financeDTO);
			FinanceDTO responseFinanceDTO = financeRepository.save(financeDTO);
			BeanUtils.copyProperties(responseFinanceDTO, financePO);
		}
		return financePO;
	}
}
