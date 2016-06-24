package com.journaldev.spring.dao;
import java.util.List;
import com.journaldev.spring.model.Country;
public interface CountryDao{

	public void addCountry(Country c);
	public void updateCountry(Country c);
	public List<Country> getAllCountries();
	public Country getCountry(int id);
	public void deleteCountry(int id);

}
