package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Country")
public class Country {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String countryName;
	
	private long population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcountryName() {
		return countryName;
	}

	public void setcountryName(String name) {
		this.countryName = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation (long population) {
		this.population = population;
	}
	
	@Override
	public String toString(){
		return "id="+id+",countryName="+countryName+", population="+population;
	}
}
