package com.grh.model.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@NotBlank(message = "le nom est obligatoire")
	private String nom;
	@NotBlank(message = "le prénom est obligatoire")
	private String prenom;
	@NotBlank(message = "le email est obligatoire")
	@Email(message = "le email doit être valide")
	private String email;
	@NotBlank(message = "le téléphone est obligatoire")
	@Size(min = 8,max = 14,message = "veuillez donner un numéro valide!")
	private String telephone;
	ProfileDTO profile;
	private List<TachesDTO> taches;
}
