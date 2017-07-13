package br.com.xyinc.dao;

import java.util.List;

import br.com.xyinc.models.PontoDeInteresse;

public interface PontoDeInteresseDao {

	/**
	 * Metodo que retorna todos os pontos de interesse cadastrados na base
	 * 
	 * @return Lista de pontos de interesse
	 */
	List<PontoDeInteresse> obterTodos();

	/**
	 * Metodo que faz a persistência do ponto de interesse na base
	 * 
	 * @return ponto de interesse persistido
	 **/
	PontoDeInteresse salvar(PontoDeInteresse ponto);

	/**
	 * Metodo que retornos os pontos de interesse proximos as coordenadas
	 * 
	 * @param
	 * @param
	 * @param
	 * @return lista de pontos de interesse
	 */
	List<PontoDeInteresse> obterProximos(Integer coordenadaX, Integer coordenadaY, Integer distancia);

}
