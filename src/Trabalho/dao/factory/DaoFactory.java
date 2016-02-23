package Trabalho.dao.factory;

import TrabalhoDao.ClienteDAO;
import TrabalhoDao.OrdemDAO;
import TrabalhoDao.OrdemExternaDAO;
import TrabalhoDao.OrdemInternaDAO;
import TrabalhoDao.StatusDAO;



public class DaoFactory {
	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;

	public static DaoFactory get() {
		if (factory == null) {
			factory = new DaoFactory();
		}
		daoFactory = new JDBCDaoFactory();
		return factory;
	}

	public ClienteDAO clienteDao() {
		return daoFactory.clienteDao();
	}

	public OrdemDAO ordemDao() {
		return daoFactory.ordemDao();
	}

	public OrdemInternaDAO ordemInternaDao() {
		return daoFactory.ordemInternaDao();
	}

	public OrdemExternaDAO ordemExternaDao() {
		return daoFactory.ordemExternaDao();
	}

	public StatusDAO statusDao() {
		return daoFactory.statusDao();
	}

	
}