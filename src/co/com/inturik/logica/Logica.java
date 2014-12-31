package co.com.inturik.logica;

import java.util.List;
import com.zupcat.service.SimpleDatastoreService;
import com.zupcat.service.SimpleDatastoreServiceFactory;

import co.com.inturik.data.DAO;
import co.com.inturik.model.User;

public class Logica {

	private DAO objDAO;

	public Logica() {

		objDAO = new DAO();

		SimpleDatastoreService service = SimpleDatastoreServiceFactory
				.getSimpleDatastoreService();

		service.registerDAO(objDAO);
	}

	public List<User> consultar() {

		return objDAO.getAll();
	}

	public void crearUsuario(User user) {

		objDAO.updateOrPersist(user);
	}

}
