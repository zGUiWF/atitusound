package br.edu.atitus.poo.atitusound.entity;

import java.time.Duration;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_music")
public class MusicEntity extends GenericEntity {

	private Duration duracao;
	private int LikesCount;
	private String URL;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "Artista_uuid")
	private ArtistEntity artista;
	
	
	public Duration getDuracao() {
		return duracao;
	}
	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}
	public int getLikesCount() {
		return LikesCount;
	}
	public void setLikesCount(int likesCount) {
		LikesCount = likesCount;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public ArtistEntity getArtista() {
		return artista;
	}
	public void setArtista(ArtistEntity artista) {
		this.artista = artista;
	}
	
	
}
