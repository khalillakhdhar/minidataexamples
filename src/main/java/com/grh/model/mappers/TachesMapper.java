package com.grh.model.mappers;

import org.modelmapper.ModelMapper;

import com.grh.model.dtos.TachesDTO;
import com.grh.model.entities.Taches;

public class TachesMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static TachesDTO convertToDTO(Taches taches)
	{
	return modelMapper.map(taches, TachesDTO.class);
	}

	public static Taches convertToEntity(TachesDTO tachesDTO)
	{
	return modelMapper.map(tachesDTO, Taches.class);	
	}
}
