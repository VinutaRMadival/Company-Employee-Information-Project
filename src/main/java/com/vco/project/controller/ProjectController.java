package com.vco.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.project.exception.ResourceNotFoundException;

import com.vco.project.model.ProjectDTO;

import com.vco.project.repository.ProjectRepository;
@RestController              //This annotation will specify the creation of RESTFUL web services.
@RequestMapping("/api/v1")    // This annotation can be used both at the class and at the method level. In most cases, at the method level applications willprefer to use one of the HTTP method specific variants

public class ProjectController {
	 @Autowired                    //This annotation is used to inject the object dependency implicitly
	    private  ProjectRepository projectRepository;

	 //get a all the projects
	    @GetMapping("/projects")
	    public List<ProjectDTO> getAllProjects() {
	        return projectRepository.findAll();
	    }
    //get a particular project with id
	    @GetMapping("/projects/{id}")
	    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(value = "id") Integer projectId)
	        throws ResourceNotFoundException {
	    	ProjectDTO project = projectRepository.findById(projectId)
	          .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
	        return ResponseEntity.ok().body(project);
	    }
	    //insert the project
	    @PostMapping("/projects")
	    public ProjectDTO createProject(@Valid @RequestBody ProjectDTO project) {
	        return projectRepository.save(project);
	    }
	    //update the project
	    @PutMapping("/projects/{id}")
	    public ResponseEntity<ProjectDTO> updateProject(@PathVariable(value = "id") Integer projectId,
	         @Valid @RequestBody ProjectDTO projectDetails) throws ResourceNotFoundException {
	    	ProjectDTO project = projectRepository.findById(projectId)
	        .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

	    	//project.setPro_id(projectDetails.getPro_id());
	    	project.setProjectCode(projectDetails.getProjectCode());
	    	project.setProjectName(projectDetails.getProjectName());
	    	project.setProjectIndustry(projectDetails.getProjectIndustry());
	    	project.setProjectStartDate(projectDetails.getProjectStartDate());
	    	project.setProjectEndDate(projectDetails.getProjectEndDate());
	    	project.setProjectBudget(projectDetails.getProjectBudget());
	    	project.setProjectPrimaryTechnology(projectDetails.getProjectPrimaryTechnology());
	    	project.setProjectSecondaryTechnology(projectDetails.getProjectSecondaryTechnology());
	    	project.setProjectClient(projectDetails.getProjectClient());
	        final ProjectDTO updatedProject = projectRepository.save(project);
	        return ResponseEntity.ok(updatedProject);
	    }
   //delete the project with id
	    @DeleteMapping("/projects/{id}")
	    public Map<String, Boolean> deleteLocation(@PathVariable(value = "id") Integer projectId)
	         throws ResourceNotFoundException {
	    	ProjectDTO project = projectRepository.findById(projectId)
	       .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

	    	projectRepository.delete(project);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
