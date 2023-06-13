package com.microservices.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.site.model.Site;

/**
 * Site Repository
 * 
 * @author SayedBaladoh
 *
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

	List<Site> findByOrganizationId(Long organizationId);

}
