package com.sponsorshiphub.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sponsorshiphub.domain.Project;
import com.sponsorshiphub.dto.ProjectDTO;
import com.sponsorshiphub.service.ProjectService;
import com.sponsorshiphub.util.ModelMapperUtil;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, value = "listar")
	public ResponseEntity<List<Project>> listar() {
		return ResponseEntity.ok().body(projectService.findAll());
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ProjectDTO projectDTO) {
		Project project = ModelMapperUtil.mapear(projectDTO, Project.class);
		projectService.insert(project);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ProjectDTO projectDTO) {
		Project project = ModelMapperUtil.mapear(projectDTO, Project.class);
		project.setId(id);
		projectService.update(project);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Project>> listByName(@RequestParam(value = "name")  String name){
		List<Project> lista = projectService.findByName(name);
		return ResponseEntity.ok().body(lista);		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="listByCountry")
	public ResponseEntity<List<Project>> listByCountry(@RequestParam(value = "country")  String name){
		List<Project> lista = projectService.search(name);
		return ResponseEntity.ok().body(lista);
				
	}
	
	@RequestMapping(method = RequestMethod.GET,value="search")
	public ResponseEntity<List<Project>> search(@RequestParam(value = "search")  String name){
		List<Project> lista = projectService.search(name);
		return ResponseEntity.ok().body(lista);
				
	}
	
	

}
