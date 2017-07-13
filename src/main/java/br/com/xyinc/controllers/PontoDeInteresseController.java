package br.com.xyinc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.xyinc.models.PontoDeInteresse;
import br.com.xyinc.services.PontoDeInteresseService;

@RestController
@RequestMapping("/pontos-interesse")
public class PontoDeInteresseController {
	
	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<?> obterTodos(){
		List<PontoDeInteresse> response = this.pontoDeInteresseService.obterTodos();
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<?> inserirPontoDeInteresse(@RequestBody PontoDeInteresse ponto) {
		try{
			this.pontoDeInteresseService.inserir(ponto);
			return new ResponseEntity<PontoDeInteresse>(ponto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@RequestMapping(value="/{coordenadaX}/{coordenadaY}/{distancia}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<?> buscarPontosDeInteresse(@PathVariable("coordenadaX") Integer coordenadaX, 
			@PathVariable("coordenadaY") Integer coordenadaY,
			@PathVariable("distancia")Integer distancia) {
		
		List<PontoDeInteresse> response = this.pontoDeInteresseService.obterProximos(coordenadaX, coordenadaY, distancia);
		return ResponseEntity.ok(response);
		
	}

}
