package br.edu.atitus.poo.atitusound.repositories;

import java.util.Optional;
import java.util.UUID;

import br.edu.atitus.poo.atitusound.entity.UserEntity;

//@Repository
public interface UserRepository extends GenericRepository<UserEntity> {

	public boolean existsByUsername(String username);
	
	public boolean existsByUsernameAndUuidNot(String username, UUID uuid);
	
	Optional<UserEntity> findByUsername(String username);
	
}
