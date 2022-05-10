package com.CrudPractice.v1;

import java.util.Optional;

import org.springframework.data.domain.Page
;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository

public interface HealthyRepo extends JpaRepository <HealthyModel,Integer>{
	
	@Query("SELECT h from HealthyModel h")
	Page<HealthyModel> fetchAllData(Pageable pageable);
	
	@Modifying
	@Query(value="UPDATE healthy h set h.vegetable =:vegetable where h.id =:id",nativeQuery=true)
	Integer updateData(Integer id, String vegetable);

	@Modifying
	@Query(value="DELETE h from healthy h  where h.id=:id",nativeQuery=true)
	Integer deleteEntryById(Integer id);

	

	HealthyModel getFindById(Integer id);

	@Query("SELECT hm from HealthyModel hm where hm.fruits=:fruits")
	HealthyModel getFindByfruits(String fruits);

	
	@Query("SELECT h from HealthyModel h where h.vegetable LIKE %:search% or h.fruits LIKE %:search% ")
	Page<HealthyModel> findAllWithSearch(Pageable pageable, String search);

	
	
	



}
