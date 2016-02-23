package TrabalhoDao;

import java.util.List;

import Trabalho.model.Entidade;


public interface CrudDAO<T extends Entidade> {

	void incluir(T entidade);
	
	void alterar(T entidade);
	
	void remover(Integer codigo);
	
	List<T> listar();
	
	T get(Integer codigo);
}