package Trabalho.model;

public class OrdemExterna extends Ordem implements Entidade {

	private Integer Cod_OrdemExterna;
	private String local;

	public OrdemExterna() {
		super();
	}

	public OrdemExterna(Integer cod_OrdemExterna, String local) {
		super();
		Cod_OrdemExterna = cod_OrdemExterna;
		this.local = local;
	}

	public Integer getCod_OrdemExterna() {
		return Cod_OrdemExterna;
	}

	public void setCod_OrdemExterna(Integer cod_OrdemExterna) {
		Cod_OrdemExterna = cod_OrdemExterna;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
