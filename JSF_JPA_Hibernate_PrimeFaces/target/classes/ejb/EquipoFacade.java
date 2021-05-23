package ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.Equipo;

@Local
public interface EquipoFacade extends AbstractFacadeJPA<Equipo>{

	public List<Object[]> nombreEquipoSalario(String codJugador,String codTemporada);
	
	
}
