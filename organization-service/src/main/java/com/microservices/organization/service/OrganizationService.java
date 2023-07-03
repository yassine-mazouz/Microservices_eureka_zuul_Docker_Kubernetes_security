package com.microservices.organization.service;

import java.util.List;
import java.util.Optional;

import com.microservices.organization.feign.UserFeign;
import com.microservices.organization.model.Organization;
import com.microservices.organization.model.User;
import com.microservices.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Organization Service
 * 
 * @author YassineMazouz
 *
 */
@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private UserFeign userFeign;


	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

	public List<Organization> getAll() {
		List<Organization> organizations = organizationRepository.findAll();
		return organizations;
	}

	public Optional<Organization> get(Long id) {
		return organizationRepository.findById(id);
	}

	public void delete(Long id) {
		organizationRepository.deleteById(id);
	}

	public void saveUser(List<User> users, Long organizationId, Long siteId) {
		User user = users.get(0);
		user.setOrganizationId(organizationId);
		user.setSiteId(siteId);
		userFeign.postUsers(user);
	}
}
