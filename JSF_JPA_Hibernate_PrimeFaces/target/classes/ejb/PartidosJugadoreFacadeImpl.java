package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import modelo.Equipo;
import modelo.PartidosJugadore;

@Stateless
public class PartidosJugadoreFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadore> implements PartidosJugadoreFacade{
	
	 @PersistenceContext(unitName="Persistencia")
	 private EntityManager em;
	
	public PartidosJugadoreFacadeImpl() {
		super(PartidosJugadore.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}
		
}
