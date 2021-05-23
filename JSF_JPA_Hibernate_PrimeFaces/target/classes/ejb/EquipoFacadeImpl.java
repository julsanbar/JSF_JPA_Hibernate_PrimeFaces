package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Equipo;

@Stateless
public class EquipoFacadeImpl extends AbstractFacadeJPAImpl<Equipo> implements EquipoFacade{

	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	
	public EquipoFacadeImpl() {
		super(Equipo.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}
	
	@Override
	public List<Object[]> nombreEquipoSalario(String codJugador,String codTemporada) {

		String jpql = "SELECT tej.salario, tej.equipo.nombrequipo FROM TempEquipoJugador tej WHERE tej.jugadore.codjugador = :codJugador AND tej.temporada.codtemp = :codTemporada";
		
		TypedQuery<Object[]> resultado = em.createQuery(jpql, Object[].class);
		
		resultado.setParameter("codJugador", codJugador);
		resultado.setParameter("codTemporada", codTemporada);
		
		return resultado.getResultList();
	}
	
	
}
