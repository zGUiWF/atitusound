package br.edu.atitus.poo.atitusound.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusound.dtos.ArtistDTO;
import br.edu.atitus.poo.atitusound.entity.ArtistEntity;
import br.edu.atitus.poo.atitusound.services.ArtistService;
import br.edu.atitus.poo.atitusound.services.GenericService;

@RestController
@RequestMapping("/artists")
public class ArtistControler extends GenericControler<ArtistEntity, ArtistDTO> {
private final ArtistService service;
	
	
	public ArtistControler(ArtistService service) {
		super();
		this.service = service;
	}
	
	protected ArtistEntity  convertDTOToEntity(ArtistDTO dto) {
		ArtistEntity entity = new ArtistEntity();
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		return entity;
	}

	@Override
	protected GenericService<ArtistEntity> getService() {
		return service;
	}
}
