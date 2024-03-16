package com.grh.dao.services;

import java.util.List;
import java.util.Optional;

import com.grh.model.entities.Taches;

public interface TacheServiceInterface {
	public List<Taches> getAllTaches();
	public Taches addOneTache(Taches taches,long idUser);
	public Optional<Taches> getOneTache(long id);
	public void deleteOneTache(long id);

}
