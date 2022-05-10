package com.CrudPractice.v1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "healthy")
public class HealthyModel {
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="vegetable")
	private String vegetable;
	@Column(name="fruits")
	private String fruits;
	@Column(name="vitamins")
	private String vitamins;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

	public String getFruits() {
		return fruits;
	}

	public void setFruits(String fruits) {
		this.fruits = fruits;
	}

	public String getVitamins() {
		return vitamins;
	}

	public void setVitamins(String vitamins) {
		this.vitamins = vitamins;
	}

	@Override
	public String toString() {
		return "HealthyModel [id=" + id + ", vegetable=" + vegetable + ", fruits=" + fruits + ", vitamins=" + vitamins
				+ "]";
	}

}