package com.microservices.user.repository;

import java.util.List;

import com.microservices.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 * 
 * @author YassineMazouz
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findBySiteId(Long siteId);

	List<User> findByOrganizationId(Long organizationId);
}
