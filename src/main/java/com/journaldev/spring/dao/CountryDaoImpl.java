package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Country;


@Repository
public class CountryDaoImpl implements CountryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCountry(Country c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Country saved successfully, Country Details="+c);
	}

	public void updateCountry(Country c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Country updated successfully, Country Details="+c);
	}

	@SuppressWarnings("unchecked")
	
	public List<Country> getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> listOfCountries = session.createQuery("from Country").list();
		for(Country c : listOfCountries){
			logger.info("listOfCountries::"+c);
		}
		return listOfCountries;
	}

	public Country getCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Country c = (Country) session.load(Country.class, new Integer(id));
		logger.info("Country loaded successfully, Country details="+c);
		return c;
	}

	public void deleteCountry (int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country c = (Country) session.load(Country.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Country deleted successfully, country details="+c);
	}

}
