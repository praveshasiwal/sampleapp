package com.example.sampleapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sampleapp.model.FinanceDTO;

@Repository
public interface FinanceRepository extends JpaRepository<FinanceDTO, Long> {

	List<FinanceDTO> findBySector(String sector);

	@Query("select f from FinanceDTO f where f.sector = ?1")
	List<FinanceDTO> findBySectorValue(String sector);

}
