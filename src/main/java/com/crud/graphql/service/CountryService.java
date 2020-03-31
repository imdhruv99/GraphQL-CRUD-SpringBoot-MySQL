package com.crud.graphql.service;

import java.util.List;

import com.crud.graphql.model.Country;


public interface CountryService {
	
	List<Country> getAllCountries();
	
	Country validateAndGetCountryById(int id);
	
	Country saveCountry(Country country);
	
	boolean deleteCountry(Country country);
	
	Country validateAndGetCountryByCountryCode(String countryCode);
	
}
