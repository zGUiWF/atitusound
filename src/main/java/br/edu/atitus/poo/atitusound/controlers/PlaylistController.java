package br.edu.atitus.poo.atitusound.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusound.dtos.PlaylistDTO;
import br.edu.atitus.poo.atitusound.entity.PlaylistEntity;
import br.edu.atitus.poo.atitusound.services.GenericService;
import br.edu.atitus.poo.atitusound.services.PlaylistService;


@RestController
@RequestMapping("/playlist")
public class PlaylistController extends GenericControler<PlaylistEntity, PlaylistDTO> {

	
	private final PlaylistService service;
	
	
	public PlaylistController(PlaylistService service) {
		super();
		this.service = service;
	}

	@Override
	protected GenericService<PlaylistEntity> getService() {
		return service;
	}

	@Override
	protected PlaylistEntity convertDTOToEntity(PlaylistDTO dto) {
		PlaylistEntity entidade = new PlaylistEntity();
		entidade.setName(dto.getName());
		entidade.setPublic_share(dto.isPublic_share());
		entidade.setMusics(dto.getMusics());
		return entidade;
	}

}
