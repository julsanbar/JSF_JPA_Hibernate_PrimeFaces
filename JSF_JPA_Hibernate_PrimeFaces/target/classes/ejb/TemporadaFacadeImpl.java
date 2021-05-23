package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Temporada;

@Stateless
public class TemporadaFacadeImpl extends AbstractFacadeJPAImpl<Temporada> implements TemporadaFacade{

	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	
	public TemporadaFacadeImpl() {
		super(Temporada.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@Override
	public List<Temporada> findAll() {

		String jpql = "SELECT t FROM Temporada t";
		
		TypedQuery<Temporada> resultado = em.createQuery(jpql, Temporada.class);
		
		return resultado.getResultList();
	}
	
	
}
