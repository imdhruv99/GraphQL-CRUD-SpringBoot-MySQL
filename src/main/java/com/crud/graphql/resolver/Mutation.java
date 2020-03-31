package com.crud.graphql.resolver;



import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.crud.graphql.input.CountryInput;
import com.crud.graphql.model.Country;
import com.crud.graphql.service.CountryService;


import ma.glasnost.orika.MapperFacade;

@Component
public class Mutation implements GraphQLMutationResolver {
	
	public CountryService countryService;
	
	public MapperFacade mapperFacade;
	
	public Mutation(CountryService countryService, MapperFacade mapperFacade) {
		this.countryService = countryService;
		this.mapperFacade = mapperFacade;
	}
	
	
	public Country createCountry(CountryInput countryInput) {
		Country country = mapperFacade.map(countryInput, Country.class);
		country.setCreatedAt(LocalDateTime.now());
		return countryService.saveCountry(country);
	}
	
	public Country updateCountry(int id, CountryInput countryInput) {
		Country country = countryService.validateAndGetCountryById(id);
		mapperFacade.map(countryInput, country);
		country.setUpdatedAt(LocalDateTime.now());
		return countryService.saveCountry(country);
	}
	
	public Country deleteCountry(int id) {
		Country country = countryService.validateAndGetCountryById(id);
		countryService.deleteCountry(country);
		return country;
	}
		
}
