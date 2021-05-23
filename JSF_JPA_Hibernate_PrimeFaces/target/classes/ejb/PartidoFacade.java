package ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.Jugadore;
import modelo.Partido;
import modelo.PartidosJugadorePK;

@Local
public interface PartidoFacade extends AbstractFacadeJPA<Partido>{

	public List<Partido> findAll();
	public Partido partidoInsert(String codPartido);
	public Jugadore jugadorInsert(String codJugador);
	
}
