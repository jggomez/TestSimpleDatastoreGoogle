package co.com.inturik;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;
import co.com.inturik.logica.Logica;
import co.com.inturik.model.User;

@SuppressWarnings("serial")
public class TestDataStoreServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Prueba DataStore");
		String firstName = req.getParameter("Nombre");
		String SecondName = req.getParameter("Apellido");

		try {
			Logica objLogica = new Logica();
			List<User> lstUser = objLogica.consultar();

			User newUser = new User();
			newUser.FIRSTNAME.set(firstName);
			newUser.LASTNAME.set(SecondName);

			objLogica.crearUsuario(newUser);

			resp.getWriter().println("Cantidad de Usuarios = " + lstUser.size());

			int i = 1;
			for (User user : lstUser) {
				resp.getWriter().println(
						"Nombre Usuario " + i + " = " + user.FIRSTNAME.get());
				resp.getWriter().println(
						"Apellido Usuario = " + i + " = " + user.LASTNAME.get());
				i++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.getWriter().println(e.getMessage());
		}
	}
}
