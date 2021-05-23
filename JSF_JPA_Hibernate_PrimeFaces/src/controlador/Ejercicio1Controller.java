package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ejb.EquipoFacade;
import ejb.JugadoreFacade;
import ejb.TemporadaFacade;
import excepciones.SeleccionListaExcepcion;
import modelo.Jugadore;
import modelo.Temporada;

@Named
@ViewScoped
public class Ejercicio1Controller implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private JugadoreFacade jugadoreFacade;
	
	@EJB
	private TemporadaFacade temporadaFacade;
	
	@EJB
	private EquipoFacade equipoFacade;
	
	private List<Jugadore> claveNombre;
	private List<SelectItem> lista1;
	
	private List<Temporada> claveTemporada;
	private List<SelectItem> lista2;
	
	String codJugador;
	String codTemporada;
	
	@PostConstruct
	public void init() {
			
		claveNombre = jugadoreFacade.findAll();
		lista1 = listaNombresJugadores(claveNombre);
		
		claveTemporada = temporadaFacade.findAll();
		lista2 = listaNombresTemporadas(claveTemporada);
		
	}
	
	public String buscarJugadores() {

		String redireccionar = null;
		List<String> nombresJugadores = jugadoreFacade.jugadoresMasTemporada(this.getCodTemporada());
		
		try {
			
			if(this.getCodTemporada().equals("-")) {
				throw new SeleccionListaExcepcion("Seleccione un campo en la lista");
			}
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("masTemporadasJugadores", nombresJugadores);
			
			redireccionar = "/resultado2.xhtml";

		}catch(SeleccionListaExcepcion eS) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vacío",eS.getMessage()));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Seleccione un campo"));
		}
		
		return redireccionar;
	}
	
	public String buscarEquipos() {
		
		String redireccionar = null;
		List<Object[]> salEqui = equipoFacade.nombreEquipoSalario(this.getCodJugador(), this.getCodTemporada());
		
		try {
			
			if((this.getCodTemporada().equals("-")) || (this.getCodJugador().equals("-"))) {
				this.setCodTemporada("-");
				throw new SeleccionListaExcepcion("Seleccione un campo en la lista");
			}
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("salarioNombre", salEqui);
			
			redireccionar = "/resultado1.xhtml";
			
		}catch(SeleccionListaExcepcion eS) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vacío",eS.getMessage()));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Seleccione un campo"));
		}
		
		return redireccionar;
	}
	

	public List<SelectItem> listaNombresJugadores(List<Jugadore> idNombre) {
		
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
		for(Jugadore item : idNombre) {
			
			resultado.add(new SelectItem(item.getCodjugador(),item.getNombrejugador()));
			
		}
		
		return resultado;
	}
	
	public List<SelectItem> listaNombresTemporadas(List<Temporada> idNombre) {
		
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
		for(Temporada item : idNombre) {
			
			resultado.add(new SelectItem(item.getCodtemp(),item.getNombre()));
			
		}
		
		return resultado;
	}	
	
	
	public JugadoreFacade getJugadoreFacade() {
		return jugadoreFacade;
	}

	public void setJugadoreFacade(JugadoreFacade jugadoreFacade) {
		this.jugadoreFacade = jugadoreFacade;
	}

	public List<Jugadore> getClaveNombre() {
		return claveNombre;
	}

	public void setClaveNombre(List<Jugadore> claveNombre) {
		this.claveNombre = claveNombre;
	}

	public List<SelectItem> getLista1() {
		return lista1;
	}

	public void setLista1(List<SelectItem> lista1) {
		this.lista1 = lista1;
	}

	public List<Temporada> getClaveTemporada() {
		return claveTemporada;
	}

	public void setClaveTemporada(List<Temporada> claveTemporada) {
		this.claveTemporada = claveTemporada;
	}

	public List<SelectItem> getLista2() {
		return lista2;
	}

	public void setLista2(List<SelectItem> lista2) {
		this.lista2 = lista2;
	}

	public TemporadaFacade getTemporadaFacade() {
		return temporadaFacade;
	}

	public void setTemporadaFacade(TemporadaFacade temporadaFacade) {
		this.temporadaFacade = temporadaFacade;
	}

	public String getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(String codJugador) {
		this.codJugador = codJugador;
	}

	public String getCodTemporada() {
		return codTemporada;
	}

	public void setCodTemporada(String codTemporada) {
		this.codTemporada = codTemporada;
	}


	
}
