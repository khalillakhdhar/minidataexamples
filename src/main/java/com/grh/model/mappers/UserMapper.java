package com.grh.model.mappers;

import org.modelmapper.ModelMapper;

import com.grh.model.dtos.UserDTO;
import com.grh.model.entities.User;

public class UserMapper {
private static final ModelMapper modelMapper= new ModelMapper();
public static UserDTO convertToDTO(User user)
{
return modelMapper.map(user, UserDTO.class);
}

public static User convertToEntity(UserDTO userDTO)
{
return modelMapper.map(userDTO, User.class);	
}

}
