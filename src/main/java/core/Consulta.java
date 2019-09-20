package core;

/**
 * O objeto consulta é utilizado para comparar os códigos de consulta salvos no arquivo códigos.txt com os do banco do SAO e a partir daí
 * continuar a execução de onde foi interrompida  
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
