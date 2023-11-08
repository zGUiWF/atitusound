package br.edu.atitus.poo.atitusound.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusound.dtos.MusicDTO;
import br.edu.atitus.poo.atitusound.entity.ArtistEntity;
import br.edu.atitus.poo.atitusound.entity.MusicEntity;
import br.edu.atitus.poo.atitusound.services.GenericService;
import br.edu.atitus.poo.atitusound.services.MusicService;

@RestController
@RequestMapping("/musics")
public class MusicControler extends GenericControler<MusicEntity, MusicDTO> {

	private final MusicService service;
	
	
	public MusicControler(MusicService service) {
		super();
		this.service = service;
	}

	@Override
	protected GenericService<MusicEntity> getService() {
		return service;
	}

	@Override
	protected MusicEntity convertDTOToEntity(MusicDTO dto) {
		MusicEntity entidade = new MusicEntity();
		entidade.setName(dto.getName());
		entidade.setDuracao(dto.getDuracao());
		entidade.setURL(dto.getURL());
		ArtistEntity artistEntity = new ArtistEntity();
		artistEntity.setUuid(dto.getArtist().getUuid());
		entidade.setArtista(artistEntity);
		return entidade;
	}

}
