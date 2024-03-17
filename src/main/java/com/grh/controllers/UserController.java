package com.grh.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.dao.services.UserServiceInterface;
import com.grh.model.dtos.UserDTO;
import com.grh.model.entities.Profile;
import com.grh.model.entities.User;
import com.grh.model.mappers.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserServiceInterface userService;
	//private final UserMapper userMapper;
@GetMapping

public ResponseEntity<List<UserDTO>> getUsers(Pageable pageable) {
    Page<User> usersPage = userService.getUsers(pageable);
    List<UserDTO> userDTOs = usersPage.getContent().stream()
            .map(UserMapper::convertToDTO)
            .collect(Collectors.toList());
    return ResponseEntity.ok(userDTOs);
}

@GetMapping("/{id}")
public ResponseEntity<UserDTO> getOneUser(@PathVariable long id)
{
return ResponseEntity.ok(UserMapper.convertToDTO(userService.getOneUser(id).get()));	
}

@PostMapping
public ResponseEntity<UserDTO> addOne(@Valid @RequestBody UserDTO user)
{
	User u=UserMapper.convertToEntity(user);
User us= userService.creaOneUser(u);
UserDTO usd=UserMapper.convertToDTO(us);
return ResponseEntity.ok(usd);

}
@PutMapping("/{userId}")
public ResponseEntity<Profile> updateProfile(@Valid @RequestBody Profile profile, @PathVariable long userId )
{
return ResponseEntity.ok(userService.updateProfile(profile, userId));	
}
@PatchMapping("/{userId}")
public ResponseEntity<User> assignProfile(@Valid @RequestBody Profile profile, @PathVariable long userId )
{
return ResponseEntity.ok(userService.AssignProfileToUser(userId, profile));	
}
@DeleteMapping("/{id}")
public void deleteOneUser(@PathVariable long id)
{
	userService.deleteOneUser(id);
}


}
