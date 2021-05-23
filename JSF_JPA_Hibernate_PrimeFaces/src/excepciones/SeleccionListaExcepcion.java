package excepciones;

public class SeleccionListaExcepcion extends Exception{
	
	private static final long serialVersionUID = 1L;

	public SeleccionListaExcepcion(String msg) {
		super(msg);
	}
	
	public SeleccionListaExcepcion() {
		super();
	}
	
}
