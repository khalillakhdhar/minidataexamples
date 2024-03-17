package com.grh.dao.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grh.dao.repositories.TachesRepository;
import com.grh.dao.repositories.UserRepository;
import com.grh.dao.services.TacheServiceInterface;
import com.grh.model.dtos.TachesDTO;
import com.grh.model.entities.Taches;
import com.grh.model.entities.User;
import com.grh.model.mappers.TachesMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TachesServiceImplement implements TacheServiceInterface {
	private final TachesRepository tachesRepository; //DI
	private final UserRepository userRepository;
	@Override
	public Page<Taches> getAllTaches(Pageable pageable) {
		// TODO Auto-generated method stub
		return tachesRepository.findAll(pageable);
	}
	

	@Override
	public TachesDTO addOneTache(@Valid TachesDTO taches, long idUser) {
		// TODO Auto-generated method stub
		Optional<User> user= userRepository.findById(idUser);
		if(!user.isEmpty())
		{
			Taches tc= TachesMapper.convertToEntity(taches);
			tc.setUser(user.get());
			return TachesMapper.convertToDTO(tachesRepository.save(tc));
		}
		else
			return null;
		
	}

	@Override
	public TachesDTO getOneTache(long id) {
		// TODO Auto-generated method stub
		return TachesMapper.convertToDTO(tachesRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneTache(long id) {
		// TODO Auto-generated method stub
		Optional<Taches> t=tachesRepository.findById(id);
		if(t.isPresent())
		{
			tachesRepository.deleteById(id);
		}
		
	}


	@Override
	public TachesDTO updateOneTache(long id,@Valid TachesDTO taches) {
		// TODO Auto-generated method stub
		Optional<Taches> t=tachesRepository.findById(id);
		Taches tc=TachesMapper.convertToEntity(taches);
		if(t.isPresent())
		{
			tc.setUser(t.get().getUser());
			tc.setId(id);
			
			return TachesMapper.convertToDTO(tachesRepository.save(tc));
			
		}
		return null;
	}

	

}
