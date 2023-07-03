package com.microservices.organization.controller;

import java.util.List;
import java.util.Optional;


import com.microservices.organization.client.SiteClient;
import com.microservices.organization.client.UserClient;
import com.microservices.organization.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.organization.service.OrganizationService;


/**
 * Organizations Controller
 * 
 * @author YassineMazouz
 *
 */
@RestController
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private SiteClient siteClient;
	@Autowired

	private UserClient userClient;

	@PostMapping
	public Organization add(@RequestBody Organization organization) {

		organizationService.save(organization);
		organizationService.saveUser(organization.getUsers(),organization.getId(),organization.getSites().get(0).getId());

		return organization;
	}

	@GetMapping
	public List<Organization> findAll() {
		return organizationService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Organization> organization = organizationService.get(id);
		if (organization.isPresent())
			return new ResponseEntity<>(organization.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>("Organization not found with id: " + id, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/with-sites")
	public Organization findByIdWithSites(@PathVariable("id") Long id) {
		Optional<Organization> organizationOpt = organizationService.get(id);
		Organization organization = null;
		if (organizationOpt.isPresent()) {
			organization = organizationOpt.get();
			organization.setSites(siteClient.findByOrganization(organization.getId()));
		}
		return organization;
	}

	@GetMapping("/{id}/with-sites-with-users")
	public Organization findByIdWithSitesAndUsers(@PathVariable("id") Long id) {

		Optional<Organization> organizationOpt = organizationService.get(id);
		Organization organization = null;
		if (organizationOpt.isPresent()) {
			organization = organizationOpt.get();
			organization.setSites(siteClient.findByOrganizationWithUsers(organization.getId()));
		}
		return organization;
	}

	@GetMapping("/{id}/with-users")
	public Organization findByIdWithUsers(@PathVariable("id") Long id) {
		Optional<Organization> organizationOpt = organizationService.get(id);
		Organization organization = null;
		if (organizationOpt.isPresent()) {
			organization = organizationOpt.get();
			organization.setUsers(userClient.findByOganizationId(organization.getId()));
		}
		return organization;
	}
}
