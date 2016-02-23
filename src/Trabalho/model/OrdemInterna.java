package Trabalho.model;

public class OrdemInterna extends Ordem implements Entidade {

	private Integer CodCodIterna;

	public OrdemInterna() {
		super();
	}

	public OrdemInterna(Integer codCodIterna) {
		super();
		CodCodIterna = codCodIterna;
	}

	public Integer getCodCodIterna() {
		return CodCodIterna;
	}

	public void setCodCodIterna(Integer codCodIterna) {
		CodCodIterna = codCodIterna;
	}

	
	
	
}
