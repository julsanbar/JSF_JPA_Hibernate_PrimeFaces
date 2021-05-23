package ejb;

import java.util.List;

import javax.ejb.Local;

import modelo.Temporada;

@Local
public interface TemporadaFacade extends AbstractFacadeJPA<Temporada>{

	public List<Temporada> findAll();
	
	
}
