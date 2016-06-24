package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.journaldev.spring.dao.CountryDao;
import com.journaldev.spring.model.Country;


@Service
public  class CountryServiceImpl implements CountryService {
	
	private CountryDao CountryDao;

	public void setCountryDao(CountryDao c) {
		this.CountryDao = c;
	}

	@Override
	@Transactional
	public void addCountry(Country c) {
		this.CountryDao.addCountry(c);
	}

	@Override
	@Transactional
	public void updateCountry(Country c) {
			this.CountryDao.updateCountry(c);
	}

	@Override
	@Transactional
	public List<Country> getAllCountries() {
		return this.CountryDao.getAllCountries();
	}

	@Override
	@Transactional
	public Country getCountry(int id) {
		return this.CountryDao.getCountry(id);
	}

	@Override
	@Transactional
	public void deleteCountry(int id) {
		this.CountryDao.deleteCountry(id);
	}}
	

