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
import javax.inject.Inject;
import javax.inject.Named;

import ejb.JugadoreFacade;
import ejb.PartidoFacade;
import ejb.PartidosJugadoreFacade;
import ejb.TemporadaFacade;
import excepciones.JugadorTemporadaExcepcion;
import excepciones.SeleccionListaExcepcion;
import modelo.Jugadore;
import modelo.Partido;
import modelo.PartidosJugadore;
import modelo.Temporada;

@Named
@ViewScoped
public class Ejercicio2Controller implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private TemporadaFacade temporadaFacade;
	
	@EJB
	private PartidoFacade partidoFacade;
	
	@EJB
	private JugadoreFacade jugadoreFacade;
	
	@EJB
	private PartidosJugadoreFacade partidosJugadoreFacade;
	
	@Inject
	private PartidosJugadore partidoJugador;
	
	private List<Temporada> claveTemporada;
	private List<SelectItem> lista2;

	private List<Partido> clavePartido;
	private List<SelectItem> lista3;
	
	private List<Jugadore> claveJugador;
	private List<SelectItem> lista4;
	
	private Integer canasta;
	private Integer asistencia;
	private Integer rebote;
	
	private String codTemporada;
	private String codPartido;
	private String codJugador;
	
	@PostConstruct
	public void init() {
			
		claveTemporada = temporadaFacade.findAll();
		lista2 = listaNombresTemporadas(claveTemporada);
		
		clavePartido = partidoFacade.findAll();
		lista3 = listaNombresPartidos(clavePartido);
		
		claveJugador = jugadoreFacade.findAll();
		lista4 = listaNombresJugadores(claveJugador);
		
	}
	
	public void insertarJugador() {
		
		Long codJugadorExistente = jugadoreFacade.jugadorTemporada(this.codTemporada, this.codJugador);
		
		try {

			if((this.getCodTemporada().equals("-")) || (this.getCodJugador().equals("-")) || (this.getCodPartido().equals("-"))) {
				throw new SeleccionListaExcepcion("Seleccione un campo en la lista");
			}
			
			if(codJugadorExistente == 0) {
				throw new JugadorTemporadaExcepcion("No hay jugadores en esa temporada");
			}
			
			Partido partidoIns = this.partidoFacade.partidoInsert(codPartido);
			Jugadore jugadorIns = this.partidoFacade.jugadorInsert(codJugador);
			
			this.partidoJugador.setPartido(partidoIns);
			this.partidoJugador.setJugadore(jugadorIns);
			
			this.partidosJugadoreFacade.create(partidoJugador);
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Insertado","Se ha insertado correctamente"));
			
		}catch(SeleccionListaExcepcion eS) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vacío",eS.getMessage()));	
		}catch(JugadorTemporadaExcepcion e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso",e.getMessage()));	
		}catch(Exception ex) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error Inesperado"+ex.getMessage()));
		}
		
	}
	
	public List<SelectItem> listaNombresTemporadas(List<Temporada> idNombre) {
		
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
		for(Temporada item : idNombre) {
			
			resultado.add(new SelectItem(item.getCodtemp(),item.getNombre()));
			
		}
		
		return resultado;
	}
	
	public List<SelectItem> listaNombresPartidos(List<Partido> idNombre) {
		
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
		for(Partido item : idNombre) {
			
			resultado.add(new SelectItem(item.getCodpartido(),item.getCodpartido()));
			
		}
		
		return resultado;
	}

	public List<SelectItem> listaNombresJugadores(List<Jugadore> idNombre) {
		
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
		for(Jugadore item : idNombre) {
			
			resultado.add(new SelectItem(item.getCodjugador(),item.getNombrejugador()));
			
		}
		
		return resultado;
	}

	/***********************************************************************/
	//-->> GETTERS Y SETTERS
	
	public TemporadaFacade getTemporadaFacade() {
		return temporadaFacade;
	}

	public PartidosJugadore getPartidoJugador() {
		return partidoJugador;
	}

	public void setPartidoJugador(PartidosJugadore partidoJugador) {
		this.partidoJugador = partidoJugador;
	}

	public void setTemporadaFacade(TemporadaFacade temporadaFacade) {
		this.temporadaFacade = temporadaFacade;
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

	public List<Partido> getClavePartido() {
		return clavePartido;
	}

	public void setClavePartido(List<Partido> clavePartido) {
		this.clavePartido = clavePartido;
	}

	public List<SelectItem> getLista3() {
		return lista3;
	}

	public void setLista3(List<SelectItem> lista3) {
		this.lista3 = lista3;
	}

	public List<Jugadore> getClaveJugador() {
		return claveJugador;
	}

	public void setClaveJugador(List<Jugadore> claveJugador) {
		this.claveJugador = claveJugador;
	}

	public List<SelectItem> getLista4() {
		return lista4;
	}

	public void setLista4(List<SelectItem> lista4) {
		this.lista4 = lista4;
	}

	public PartidoFacade getPartidoFacade() {
		return partidoFacade;
	}

	public void setPartidoFacade(PartidoFacade partidoFacade) {
		this.partidoFacade = partidoFacade;
	}

	public JugadoreFacade getJugadoreFacade() {
		return jugadoreFacade;
	}

	public void setJugadoreFacade(JugadoreFacade jugadoreFacade) {
		this.jugadoreFacade = jugadoreFacade;
	}

	public Integer getCanasta() {
		return canasta;
	}

	public void setCanasta(Integer canasta) {
		this.canasta = canasta;
	}

	public Integer getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Integer asistencia) {
		this.asistencia = asistencia;
	}

	public Integer getRebote() {
		return rebote;
	}

	public void setRebote(Integer rebote) {
		this.rebote = rebote;
	}

	public String getCodTemporada() {
		return codTemporada;
	}

	public void setCodTemporada(String codTemporada) {
		this.codTemporada = codTemporada;
	}

	public String getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(String codPartido) {
		this.codPartido = codPartido;
	}

	public String getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(String codJugador) {
		this.codJugador = codJugador;
	}
	
	
}
