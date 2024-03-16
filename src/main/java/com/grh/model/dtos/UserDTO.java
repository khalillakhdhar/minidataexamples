package com.grh.model.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
		@NotBlank(message = "le nom est obligatoire")
		String nom,
		@NotBlank(message = "le prénom est obligatoire")
		String prenom,
		@NotBlank(message = "le email est obligatoire")
		@Email(message = "le email doit être valide")
		String email,
		@NotBlank(message = "le téléphone est obligatoire")
		@Size(min = 8,max = 14,message = "veuillez donner un numéro valide!")
		String telephone,
		ProfileDTO profilDTO,
		List<TachesDTO> tachesDTOs
		
		
		) {

}
