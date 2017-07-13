package br.com.xyinc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.xyinc.dao.PontoDeInteresseDao;
import br.com.xyinc.models.PontoDeInteresse;
import br.com.xyinc.services.PontoDeInteresseService;

@Service
public class PontoDeInteresseServiceImpl implements PontoDeInteresseService {

	@Autowired
	private PontoDeInteresseDao pontoDeInteresseDao;

	@Transactional(readOnly = true)
	@Override
	public List<PontoDeInteresse> obterTodos() {
		return this.pontoDeInteresseDao.obterTodos();
	}

	@Transactional
	@Override
	public PontoDeInteresse inserir(PontoDeInteresse ponto) {
		this.validarPontoDeInteresse(ponto);
		ponto = this.pontoDeInteresseDao.salvar(ponto);
		return ponto;
	}

	private void validarPontoDeInteresse(PontoDeInteresse ponto) {
		if (null == ponto.getNome()) {
			throw new IllegalArgumentException("Nome informado inválido");
		} else if (ponto.getCoordenadaX() < 0) {
			throw new IllegalArgumentException("Coordenada X não pode ser negativa");
		} else if (ponto.getCoordenadaY() < 0) {
			throw new IllegalArgumentException("Coordenada Y não pode ser negativa");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<PontoDeInteresse> obterProximos(Integer coordenadaX, Integer coordenadaY, Integer distancia) {
		return this.pontoDeInteresseDao.obterProximos(coordenadaX, coordenadaY, distancia);
	}

}
