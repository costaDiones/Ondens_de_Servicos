package Trabalho.model;





public  class Cliente implements Entidade {

	private Integer Codigo;
	private String Nome;
	private String Endereco;
	private String Telefone;
	private String cpf;
	private Integer quantidadeClientes;
	private Ordem ordens;
	
	
	

	
	
	


	public Cliente() {
		super();
	}

	public Cliente(Integer codigo, String nome, String endereco,
			String telefone, String cpf, Ordem ordens) {
		super();
		Codigo = codigo;
		Nome = nome;
		Endereco = endereco;
		Telefone = telefone;
		this.cpf = cpf;
		this.ordens = ordens;
	}
	
	
	
	

	

	public Integer getquantidadeClientes() {
		return quantidadeClientes;
	}

	public void setquantidadeClientes(Integer quantidadeClientes) {
		this.quantidadeClientes = quantidadeClientes;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Ordem getOrdens() {
		return ordens;
	}

	public void setOrdens(Ordem ordens) {
		this.ordens = ordens;
	}

	
	
	
}
