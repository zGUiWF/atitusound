package br.edu.atitus.poo.atitusound.dtos;

import java.time.Duration;


public class MusicDTO {

	private String name;
	private Duration duracao;
	private String URL;
	private DTOOnlyUUID artist;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Duration getDuracao() {
		return duracao;
	}
	public void setDuracao(Duration duracao) {
		this.duracao = duracao;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public DTOOnlyUUID getArtist() {
		return artist;
	}
	public void setArtist(DTOOnlyUUID artist) {
		this.artist = artist;
	}
	
	
	
	
}
