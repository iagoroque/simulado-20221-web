package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.util.List;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class UsuarioListController extends HttpServlet {

	private UsuarioDAO dao = new UsuarioDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Usuario> lista = dao.findAll();
		req.setAttribute("usuarios", lista);
		
		req.getRequestDispatcher("/lista.jsp").forward(req, resp);
	}

}
