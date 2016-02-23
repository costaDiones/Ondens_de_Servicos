package Trabalho.dao.factory;

import TrabalhoDao.ClienteDAO;
import TrabalhoDao.OrdemDAO;
import TrabalhoDao.OrdemExternaDAO;
import TrabalhoDao.OrdemInternaDAO;
import TrabalhoDao.StatusDAO;






public interface AbstractDaoFactory {
	
	ClienteDAO clienteDao();
	OrdemDAO ordemDao();
	OrdemInternaDAO ordemInternaDao();	
	OrdemExternaDAO ordemExternaDao();
	StatusDAO statusDao();
	
	
}




