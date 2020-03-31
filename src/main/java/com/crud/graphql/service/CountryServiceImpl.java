package com.crud.graphql.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.graphql.exception.CountryNotFoundException;
import com.crud.graphql.model.Country;
import com.crud.graphql.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;
	
	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}


	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public boolean deleteCountry(Country country) {
		countryRepository.delete(country);
		return true;
	}

	@Override
	public Country validateAndGetCountryByCountryCode(String countryCode) {
		return countryRepository.findByCountryCode(countryCode).orElseThrow(() -> new CountryNotFoundException("Country Not Found!!", "countryCode", countryCode));
	}

	@Override
	public Country validateAndGetCountryById(int id) {
		return countryRepository.findById(id);
	}

}
