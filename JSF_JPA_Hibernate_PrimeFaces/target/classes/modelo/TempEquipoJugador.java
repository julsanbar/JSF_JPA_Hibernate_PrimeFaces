package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEMP_EQUIPO_JUGADOR database table.
 * 
 */
@Entity
@Table(name="TEMP_EQUIPO_JUGADOR")
public class TempEquipoJugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TempEquipoJugadorPK id;

	@Column(name="SALARIO")
	private int salario;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="CODEQUIPO")
	private Equipo equipo;

	//bi-directional many-to-one association to Jugadore
	@ManyToOne
	@JoinColumn(name="CODJUGADOR")
	private Jugadore jugadore;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="CODTEMP")
	private Temporada temporada;

	public TempEquipoJugador() {
	}

	public TempEquipoJugadorPK getId() {
		return this.id;
	}

	public void setId(TempEquipoJugadorPK id) {
		this.id = id;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jugadore getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

	public Temporada getTemporada() {
		return this.temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

}