package com.springboot.restapi.onetomany.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restapi.onetomany.model.UserProfile;




@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
	
	List<UserProfile> findAll(Sort sort);

}
