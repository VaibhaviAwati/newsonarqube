package com.CrudPractice.v1;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HealthyServiceImpl implements HealthyService {
	@Autowired
	HealthyRepo healthyRepo;
	Pageable pageable;

	@Override
	public Page<HealthyModel> fetchAllData(Integer limit, Integer offset) {
		pageable = new LimitOffset(limit, offset, "id");

		return healthyRepo.fetchAllData(pageable);
	}

	@Override
	public HealthyModel save(HealthyModel healthy) {
		// TODO Auto-generated method stub
		return healthyRepo.save(healthy);
	}

	

	@Override
	public Integer updateData(Integer id, String vegetable) {
		
		return healthyRepo.updateData(id,vegetable);
	}

	@Override
	public Integer deleteEntryById(Integer id) {
		
		return healthyRepo.deleteEntryById(id);
	}

	@Override
	public HealthyModel getFindById(Integer id) {
		
		return healthyRepo.getFindById(id);
	}

	@Override
	public HealthyModel getFindByfruits(String fruits) {
		
		return healthyRepo.getFindByfruits(fruits);
	}

	@Override
	public Page<HealthyModel> findAllWithSearch(Integer limit, Integer skip, String search) {
		
		return  healthyRepo.findAllWithSearch(pageable,search);
	}

	

	
	

	
	


	

}

	
	


