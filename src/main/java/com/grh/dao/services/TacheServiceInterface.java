package com.grh.dao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grh.model.dtos.TachesDTO;
import com.grh.model.entities.Taches;

public interface TacheServiceInterface {
	public Page<Taches> getAllTaches(Pageable pageable );
	public TachesDTO addOneTache(TachesDTO taches,long idUser);
	public TachesDTO getOneTache(long id);
	public void deleteOneTache(long id);
	public TachesDTO updateOneTache(long id,TachesDTO taches);

}
