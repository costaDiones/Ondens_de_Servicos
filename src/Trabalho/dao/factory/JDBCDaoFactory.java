package Trabalho.dao.factory;

import Trabalho.jdbc.dao.ClienteJDBC;
import Trabalho.jdbc.dao.OrdemExternaJDBC;
import Trabalho.jdbc.dao.OrdemInternaJDBC;
import Trabalho.jdbc.dao.OrdemJDBC;
import Trabalho.jdbc.dao.StatusJDBC;
import TrabalhoDao.ClienteDAO;
import TrabalhoDao.OrdemDAO;
import TrabalhoDao.OrdemExternaDAO;
import TrabalhoDao.OrdemInternaDAO;
import TrabalhoDao.StatusDAO;





public class JDBCDaoFactory implements AbstractDaoFactory {

	public ClienteDAO clienteDao() {
		return new ClienteJDBC();
	}

	public OrdemDAO ordemDao() {
		return  new OrdemJDBC();
	}

	public OrdemInternaDAO ordemInternaDao() {
		return  new OrdemInternaJDBC();
	}

	public OrdemExternaDAO ordemExternaDao() {
		return  new OrdemExternaJDBC();
	}

	public StatusDAO statusDao() {
		return new StatusJDBC();
	}
}
