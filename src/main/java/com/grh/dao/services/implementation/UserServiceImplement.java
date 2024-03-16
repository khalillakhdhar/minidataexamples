package com.grh.dao.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grh.dao.repositories.ProfileRepository;
import com.grh.dao.repositories.UserRepository;
import com.grh.dao.services.UserServiceInterface;
import com.grh.model.entities.Profile;
import com.grh.model.entities.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserServiceInterface {

	// Dependency injection
	private final UserRepository userRepository;
	private final ProfileRepository profileRepository;
	
	@Override
	@Transactional()
	public Page<User> getUsers(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	@Override
	public Optional<User> getOneUser(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void deleteOneUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public User AssignProfileToUser(long Userid, Profile profile) {
		// TODO Auto-generated method stub
		return userRepository.findById(Userid).map(user->
		{
			profile.setUser(user);
			user.setProfile(profile);
			return userRepository.save(user);
		}
				).orElseThrow(()->new EntityNotFoundException("user not found with id"+Userid) )
				;
	}

	@Override
	public Profile updateProfile(Profile profile, long userId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(userId).map(userProfile->
		{
			userProfile=profile;
			userProfile.setId(userId);
			return profileRepository.save(userProfile);
		}
				).orElseThrow(()->new EntityNotFoundException("profile not found with id"+userId) )
				;
	}

	@Override
	public User creaOneUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
