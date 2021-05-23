package ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.Jugadore;
import modelo.Partido;
import modelo.PartidosJugadore;

@Local
public interface PartidosJugadoreFacade extends AbstractFacadeJPA<PartidosJugadore>{
		
}
