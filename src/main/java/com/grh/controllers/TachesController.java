package com.grh.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.dao.services.TacheServiceInterface;
import com.grh.model.dtos.TachesDTO;
import com.grh.model.entities.Taches;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taches")
public class TachesController {
	private final TacheServiceInterface tacheServiceInterface;
	
	@GetMapping
	public ResponseEntity<Page<Taches>> getAllTaches(Pageable pageable)
	{
		return ResponseEntity.ok(tacheServiceInterface.getAllTaches(pageable));
	}
	@PostMapping("/{idUser}")
	public ResponseEntity<TachesDTO> addOneTache(@RequestBody TachesDTO taches,@PathVariable  long idUser)
	{
		return ResponseEntity.ok(tacheServiceInterface.addOneTache(taches, idUser));
	}
	@GetMapping("/{id}")
	public ResponseEntity<TachesDTO> getOneTache(@PathVariable long id)
	{
		return ResponseEntity.ok(tacheServiceInterface.getOneTache(id));
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable  long id)
	{
		tacheServiceInterface.deleteOneTache(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<TachesDTO> updateOne(@PathVariable  long id,@RequestBody TachesDTO taches)
	{
		return ResponseEntity.ok(tacheServiceInterface.updateOneTache(id, taches));
	}
	
	
	

}
