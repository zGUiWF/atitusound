package br.edu.atitus.poo.atitusound.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.poo.atitusound.entity.UserEntity;

public interface UserService extends GenericService<UserEntity>, UserDetailsService {

	
}
