package com.sponsorshiphub.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sponsorshiphub.domain.Project;

public interface ProjectRepository extends MongoRepository<Project, Long> {

	List<Project> findByNameLike(String name);

	List<Project> findByCountryIgnoreCase(String country);

	@Query("{ $or: [ {country : ?0}, {name:?0 },{ description:?0 } ] }")
	List<Project> serach(String name);

	

}
