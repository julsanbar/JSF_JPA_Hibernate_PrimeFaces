package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Jugadore;
import modelo.Partido;
import modelo.PartidosJugadorePK;

@Stateless
public class PartidoFacadeImpl extends AbstractFacadeJPAImpl<Partido> implements PartidoFacade{

	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	
	public PartidoFacadeImpl() {
		super(Partido.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@Override
	public List<Partido> findAll() {

		String jpql = "SELECT p FROM Partido p";
		
		TypedQuery<Partido> resultado = em.createQuery(jpql, Partido.class);
		
		return resultado.getResultList();
	}

	@Override
	public Partido partidoInsert(String codPartido) {
		
		String jpql = "SELECT p FROM Partido p where p.codpartido = :codPartido";
		
		TypedQuery<Partido> resultado = em.createQuery(jpql, Partido.class);
		
		resultado.setParameter("codPartido", codPartido);
		
		return resultado.getSingleResult();
	}

	@Override
	public Jugadore jugadorInsert(String codJugador) {
		
		String jpql = "SELECT p FROM Jugadore p where p.codjugador = :codJugador";
		
		TypedQuery<Jugadore> resultado = em.createQuery(jpql, Jugadore.class);
		
		resultado.setParameter("codJugador", codJugador);
		
		return resultado.getSingleResult();
	}

	
	

}
