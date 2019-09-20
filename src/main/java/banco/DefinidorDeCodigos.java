package banco;

import java.io.IOException;
import java.util.List;

import core.Consulta;

public interface DefinidorDeCodigos {

	public abstract List<Consulta> defineListaCodigos() throws IOException;
	
}
