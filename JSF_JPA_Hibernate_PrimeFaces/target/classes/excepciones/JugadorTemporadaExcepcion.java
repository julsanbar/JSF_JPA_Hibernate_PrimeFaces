package excepciones;

public class JugadorTemporadaExcepcion extends Exception{
	
	private static final long serialVersionUID = 1L;

	public JugadorTemporadaExcepcion(String msg) {
		super(msg);
	}
	
	public JugadorTemporadaExcepcion() {
		super();
	}
	
}
