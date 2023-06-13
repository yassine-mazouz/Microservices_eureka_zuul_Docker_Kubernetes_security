package com.microservices.site.controller;

import java.util.List;
import java.util.Optional;

import com.microservices.site.client.UserClient;
import com.microservices.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.site.model.Site;

/**
 * Sites Controller
 * 
 * @author SayedBaladoh
 *
 */
@RestController
public class SiteController {

	@Autowired
	private SiteService siteService;

	@Autowired
	private UserClient userClient;

	@PostMapping
	public Site add(@RequestBody Site site) {
		return siteService.save(site);
	}

	@GetMapping
	public List<Site> findAll() {
		return siteService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Site> site = siteService.get(id);
		if (site.isPresent())
			return new ResponseEntity<>(site.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>("Site not found with id: " + id, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/organization/{organizationId}")
	public List<Site> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		return siteService.getByOrganizationId(organizationId);
	}

	@GetMapping("/organization/{organizationId}/with-users")
	public List<Site> findByOrganizationWithUsers(@PathVariable("organizationId") Long organizationId) {
		List<Site> sites = siteService.getByOrganizationId(organizationId);
		sites.forEach(s -> s.setUsers(userClient.findBySiteId(s.getId())));
		return sites;
	}
}
