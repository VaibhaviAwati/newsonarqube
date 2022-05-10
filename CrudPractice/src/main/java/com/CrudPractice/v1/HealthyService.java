package com.CrudPractice.v1;

import org.springframework.data.domain.Page;

public interface HealthyService {

	Page<HealthyModel> fetchAllData(Integer limit, Integer offset);

	HealthyModel save(HealthyModel healthy);

	Integer updateData(Integer id, String vegetable);

	Integer deleteEntryById(Integer id);

	public HealthyModel getFindById(Integer id);

 HealthyModel getFindByfruits(String fruits);

Page<HealthyModel> findAllWithSearch(Integer limit, Integer skip, String search);


	



	

	

}
