package br.com.xyinc.services;

import java.util.List;

import br.com.xyinc.models.PontoDeInteresse;

public interface PontoDeInteresseService {

	/**
	 * Busca todos os pontos de interesse cadastrados na base
	 * 
	 * @return lista de pontos de interesse
	 */
	List<PontoDeInteresse> obterTodos();

	/**
	 * Persiste o ponto de interesse na base
	 * 
	 * @return ponto de interesse persistido
	 **/
	PontoDeInteresse inserir(PontoDeInteresse ponto);

	/**
	 * Obtem os pontos de interesse proximos, baseados nas coordenadas e limitado 
	 * a distância especificada.
	 * @param 
	 * @param 
	 * @param
	 * @return lista de pontos de interesse
	 * */
	List<PontoDeInteresse> obterProximos(Integer coordenadaX, Integer coordenadaY, Integer distancia);

}
