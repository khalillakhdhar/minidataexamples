package com.grh.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
