package com.grh.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class TachesDTO {
	@NotBlank(message = "le titre est obligatoire")
	private String titre;
	private String description;
}
