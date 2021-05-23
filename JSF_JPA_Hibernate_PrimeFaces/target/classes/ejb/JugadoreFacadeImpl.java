package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Jugadore;

@Stateless
public class JugadoreFacadeImpl extends AbstractFacadeJPAImpl<Jugadore> implements JugadoreFacade{

	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	
	public JugadoreFacadeImpl() {
		super(Jugadore.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@Override
	public List<Jugadore> findAll() {

		String jpql = "SELECT j FROM Jugadore j";
		
		TypedQuery<Jugadore> resultado = em.createQuery(jpql, Jugadore.class);
		
		return resultado.getResultList();
	}

	@Override
	public List<String> jugadoresMasTemporada(String codTemporada) {
		
		String jpql = "SELECT DISTINCT tej.jugadore.nombrejugador FROM TempEquipoJugador tej WHERE (SELECT COUNT(e.equipo.codequipo) FROM TempEquipoJugador e WHERE (e.jugadore.codjugador = tej.jugadore.codjugador) AND (e.temporada.codtemp = :codTemp)) > 1";
		
		TypedQuery<String> resultado = em.createQuery(jpql, String.class);
		
		resultado.setParameter("codTemp",codTemporada);
		
		return resultado.getResultList();
	}

	@Override
	public Long jugadorTemporada(String codTemporada,String codJugador) {
		
		String jpql = "SELECT COUNT(j.jugadore.codjugador) FROM TempEquipoJugador j WHERE j.temporada.codtemp = :codTemp AND j.jugadore.codjugador = :codJugador";
		
		TypedQuery<Long> resultado = em.createQuery(jpql, Long.class);
		
		resultado.setParameter("codTemp", codTemporada);
		resultado.setParameter("codJugador", codJugador);
		
		return resultado.getSingleResult();
	}

	
	
}
