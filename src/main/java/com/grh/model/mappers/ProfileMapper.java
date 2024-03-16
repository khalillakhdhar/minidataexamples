package com.grh.model.mappers;

import org.modelmapper.ModelMapper;

import com.grh.model.dtos.ProfileDTO;
import com.grh.model.entities.Profile;

public class ProfileMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static ProfileDTO convertToDTO(Profile profile)
	{
	return modelMapper.map(profile, ProfileDTO.class);
	}

	public static Profile convertToEntity(ProfileDTO profileDTO)
	{
	return modelMapper.map(profileDTO, Profile.class);	
	}
}
