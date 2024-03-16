package com.grh.dao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grh.model.entities.Profile;
import com.grh.model.entities.User;

public interface UserServiceInterface {
	public Page<User> getUsers(Pageable pageable);
	public Optional<User> getOneUser(long id);
	public User creaOneUser(User user);
	public void deleteOneUser(long id);
	public User AssignProfileToUser(long Userid,Profile profile);
	public Profile updateProfile(Profile profile, long userId);
	

}
