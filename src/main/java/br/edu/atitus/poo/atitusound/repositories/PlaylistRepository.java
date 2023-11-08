package br.edu.atitus.poo.atitusound.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.poo.atitusound.entity.PlaylistEntity;
import br.edu.atitus.poo.atitusound.entity.UserEntity;

@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity> {

	Page<List<PlaylistEntity>> findByNameContainingIgnoreCaseAndUserOrPublicShare(String Name,UserEntity user,Boolean publicShare, Pageable pageable);

}
