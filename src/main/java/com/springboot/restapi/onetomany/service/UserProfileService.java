package com.springboot.restapi.onetomany.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.restapi.onetomany.model.UserProfile;
import com.springboot.restapi.onetomany.repository.UserProfileRepository;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }
    
    public Page<UserProfile> findall(Pageable pageable){
    	return userProfileRepository.findAll(pageable);
    }

    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile findById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userProfileRepository.deleteById(id);
    }
    
    public List<UserProfile> getAllProfiles(Sort sort) {
        return userProfileRepository.findAll(sort);
    }
}
