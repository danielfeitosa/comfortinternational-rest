package com.sponsorshiphub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sponsorshiphub.domain.Project;
import com.sponsorshiphub.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public void insert(Project project) {
		projectRepository.save(project);
	}

	public List<Project> findByName(String name) {
		return projectRepository.findByNameLike(name);
	}

	public List<Project> findByCountry(String country) {
		return projectRepository.findByCountryIgnoreCase(country);
	}

	public List<Project> search(String country) {
		return projectRepository.serach(country);
	}

	public void update(Project project) {
		projectRepository.save(project);

	}

}
