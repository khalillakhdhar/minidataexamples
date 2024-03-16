package com.grh.model.dtos;

import jakarta.validation.constraints.NotBlank;

public record TachesDTO(
		@NotBlank(message = "le titre est obligatoire")
		String titre,
		String description
		
		) {

}
