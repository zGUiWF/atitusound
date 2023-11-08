package br.edu.atitus.poo.atitusound.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.poo.atitusound.entity.GenericEntity;
import br.edu.atitus.poo.atitusound.repositories.GenericRepository;

public interface GenericService<TEntidade extends GenericEntity> {

	GenericRepository<TEntidade> getRepository();
	
	default void validate(TEntidade entity)throws Exception{
		if(entity.getName() == null || entity.getName().isEmpty())
			throw new Exception("campo nome invalido");
		if(entity.getUuid() == null) {
			if(getRepository().existsByName(entity.getName()))
				throw new Exception("Ja existe registro com esse nome");
		}else {
			if(!getRepository().existsById(entity.getUuid()))
				throw new Exception("Nao existe registro com esse id");
			if(getRepository().existsByNameAndUuidNot(entity.getName(), entity.getUuid()))
				throw new Exception("Ja existe registrom com esse nome ");
			}
		}
	
	default void validateDeleteById(UUID uuid)throws Exception {
		if(!getRepository().existsById(uuid))
			throw new Exception("Nao existe um registro com esse id");
	}
	
	default void validateFindById(UUID uuid) throws Exception {
		
	}
	
	default void validateFindByName(String name,Pageable pageable) throws Exception {
		
	}

	
	default TEntidade save(TEntidade entity) throws Exception {
		validate(entity);
		getRepository().save(entity);
		return entity;
	}

	
	default List<TEntidade> findAll() throws Exception {
		return getRepository().findAll();
	}

	
	default Page<List<TEntidade>> findByNameContainingIgnoreCase(String Name, Pageable pageable) throws Exception {
		validateFindByName(Name, pageable);
		return getRepository().findByNameContainingIgnoreCase(Name, pageable);
	}

	
	default Optional<TEntidade> findById(UUID uuid) throws Exception {
		validateFindById(uuid);
		return getRepository().findById(uuid);
	}

	
	default void deleteById(UUID uuid) throws Exception {
		validateDeleteById(uuid);
		getRepository().deleteById(uuid);
		
	}
}
