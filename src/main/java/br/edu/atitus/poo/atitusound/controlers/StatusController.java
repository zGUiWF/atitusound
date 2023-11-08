package br.edu.atitus.poo.atitusound.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {
	
	@GetMapping
	public String GetStatus(){
		return("Aplicaçao esta no ar");
	}
	@PostMapping
	public ResponseEntity<String> PostStatus(@RequestBody String textoEntrada) {
		System.out.println(textoEntrada);
		return ResponseEntity.status(HttpStatus.CREATED).body("registro criado com sucesso");
	}
}
