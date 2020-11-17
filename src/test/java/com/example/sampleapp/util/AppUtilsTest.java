package com.example.sampleapp.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sampleapp.model.FinanceDTO;
import com.example.sampleapp.model.FinancePO;

@SpringBootTest
public class AppUtilsTest {

	@Test
	public void testCopySourceToTargetPositive() {
		FinanceDTO financeDTO = new FinanceDTO();
		financeDTO.setId(1L);
		financeDTO.setNumberOfCustomer(11L);
		financeDTO.setNumberOfFacilities(2);
		financeDTO.setSector("ABC");
		
		FinancePO financePO = AppUtils.copySourceToTarget(financeDTO, FinancePO.class);
		assertNotNull(financePO);
		assertEquals(financeDTO.getNumberOfCustomer(), financePO.getNumberOfCustomer());
	}
	
	@Test(expected = RuntimeException.class)
	public void testCopySourceToTargetNegative(){
		
		AppUtils.copySourceToTarget("Non JSON, String Value", FinancePO.class);
		
	}
}