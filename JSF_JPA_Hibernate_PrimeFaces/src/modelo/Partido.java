package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PARTIDOS database table.
 * 
 */
@Entity
@Table(name="PARTIDOS")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODPARTIDO")
	private String codpartido;

	@Column(name="JORNADA")
	private int jornada;

	@Column(name="PUNTOSLOCAL")
	private int puntoslocal;

	@Column(name="PUNTOSVISITANTE")
	private int puntosvisitante;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="CODEQUIPOLOCAL")
	private Equipo equipo1;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="CODEQUIPOVISITANTE")
	private Equipo equipo2;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="TEMPORADA")
	private Temporada temporadaBean;

	//bi-directional many-to-one association to PartidosJugadore
	@OneToMany(mappedBy="partido")
	private List<PartidosJugadore> partidosJugadores;

	public Partido() {
	}

	public String getCodpartido() {
		return this.codpartido;
	}

	public void setCodpartido(String codpartido) {
		this.codpartido = codpartido;
	}

	public int getJornada() {
		return this.jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public int getPuntoslocal() {
		return this.puntoslocal;
	}

	public void setPuntoslocal(int puntoslocal) {
		this.puntoslocal = puntoslocal;
	}

	public int getPuntosvisitante() {
		return this.puntosvisitante;
	}

	public void setPuntosvisitante(int puntosvisitante) {
		this.puntosvisitante = puntosvisitante;
	}

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Temporada getTemporadaBean() {
		return this.temporadaBean;
	}

	public void setTemporadaBean(Temporada temporadaBean) {
		this.temporadaBean = temporadaBean;
	}

	public List<PartidosJugadore> getPartidosJugadores() {
		return this.partidosJugadores;
	}

	public void setPartidosJugadores(List<PartidosJugadore> partidosJugadores) {
		this.partidosJugadores = partidosJugadores;
	}

	public PartidosJugadore addPartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().add(partidosJugadore);
		partidosJugadore.setPartido(this);

		return partidosJugadore;
	}

	public PartidosJugadore removePartidosJugadore(PartidosJugadore partidosJugadore) {
		getPartidosJugadores().remove(partidosJugadore);
		partidosJugadore.setPartido(null);

		return partidosJugadore;
	}

}