package br.edu.atitus.poo.atitusound.dtos;

import java.util.List;

import br.edu.atitus.poo.atitusound.entity.MusicEntity;

public class PlaylistDTO {
	
	private String name;
	
	private boolean public_share;
	
	private List<MusicEntity> musics;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublic_share() {
		return public_share;
	}

	public void setPublic_share(boolean public_share) {
		this.public_share = public_share;
	}

	public List<MusicEntity> getMusics() {
		return musics;
	}

	public void setMusics(List<MusicEntity> musics) {
		this.musics = musics;
	}
	
	
}
