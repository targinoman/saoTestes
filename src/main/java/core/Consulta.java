package core;

/**
 * O objeto consulta � utilizado para comparar os c�digos de consulta salvos no arquivo c�digos.txt com os do banco do SAO e a partir da�
 * continuar a execu��o de onde foi interrompida  
 * 
 * @author rstargino
 * 
 **/

public class Consulta {

	private String codigo;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Consulta) {
			Consulta c = (Consulta)obj;
			return this.codigo.equals(c.getCodigo());			
		}else {
			return false;
		}
		
	}

}
