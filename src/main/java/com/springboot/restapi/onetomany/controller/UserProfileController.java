package com.springboot.restapi.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.springboot.restapi.onetomany.model.UserProfile;
import com.springboot.restapi.onetomany.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return userProfileService.findAll();
    }
    
   @GetMapping("/page")
   public Page<UserProfile> getProfiles(Pageable pageable){
	   return userProfileService.findall(pageable);
   }

    @PostMapping
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.save(userProfile);
    }

    @GetMapping("/{id}")
    public UserProfile getProfileById(@PathVariable Long id) {
        return userProfileService.findById(id);
    }

    @PutMapping("/{id}")
    public UserProfile updateProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
        userProfile.setId(id);
        return userProfileService.save(userProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        userProfileService.deleteById(id);
    }
    
    @GetMapping("/sorting")
    public List<UserProfile> getAllProfiles(@RequestParam(required = false) String sortBy) {
        Sort sort = Sort.by(sortBy != null ? sortBy : "id");
        return userProfileService.getAllProfiles(sort);
    }
}
