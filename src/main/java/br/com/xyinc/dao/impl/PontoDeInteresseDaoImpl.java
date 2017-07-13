package br.com.xyinc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.xyinc.dao.PontoDeInteresseDao;
import br.com.xyinc.models.PontoDeInteresse;

@Repository
public class PontoDeInteresseDaoImpl extends SimpleGenericDao implements PontoDeInteresseDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PontoDeInteresse> obterTodos() {
		Criteria criteria = this.getSession().createCriteria(PontoDeInteresse.class);
		return criteria.list();
	}

	@Override
	public PontoDeInteresse salvar(PontoDeInteresse ponto) {
		this.persist(ponto);
		return ponto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PontoDeInteresse> obterProximos(Integer coordenadaX, Integer coordenadaY, Integer distancia) {
		Query query = this.getSession().createQuery("SELECT pi FROM PontoDeInteresse pi WHERE (ABS(pi.coordenadaX - :coordenadaX) + ABS(pi.coordenadaY - :coordenadaY)) <= :distancia");
		query.setParameter("coordenadaX", coordenadaX);
		query.setParameter("coordenadaY", coordenadaY);
		query.setParameter("distancia", distancia);
		
		return query.list();
		
	}
	
}
