package com.crud.graphql.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.graphql.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
	
	Optional<Country> findByCountryCode(String countryCode);

	Country findById(int id);
	
}
