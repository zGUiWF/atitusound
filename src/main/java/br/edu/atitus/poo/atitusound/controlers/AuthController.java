package br.edu.atitus.poo.atitusound.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusound.dtos.SigninDTO;
import br.edu.atitus.poo.atitusound.dtos.UserDTO;
import br.edu.atitus.poo.atitusound.entity.UserEntity;
import br.edu.atitus.poo.atitusound.services.UserService;
import br.edu.atitus.poo.atitusound.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserService service;
	private final AuthenticationConfiguration authconfig;

	public AuthController(UserService service, AuthenticationConfiguration authconfig) {
		super();
		this.service = service;
		this.authconfig = authconfig;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserEntity> PostSignup(@RequestBody UserDTO dto){
		UserEntity entidade = new UserEntity();
		entidade.setEmail(dto.getEmail());
		entidade.setPassword(dto.getPassword());
		entidade.setUsername(dto.getUsername());
		entidade.setName(dto.getName());
		
		try {
			service.save(entidade);
		} catch (Exception e) {
			return ResponseEntity.badRequest().header("Error", e.getMessage()).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> PostSignin(@RequestBody SigninDTO signin){
		try {
			authconfig.getAuthenticationManager().authenticate(	
				new UsernamePasswordAuthenticationToken(signin.getUsername(), signin.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error", e.getMessage()).build();
		}
		
		return ResponseEntity.ok(JwtUtil.generateTokenFromUsername(signin.getUsername()));
	}
	
}
