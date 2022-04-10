package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private UsuarioDAO udao = new UsuarioDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario user = udao.findByLogin(login);

		// Sistema de Autenticacao
		if (user == null) {
			resp.sendRedirect("/login.jsp");
		} else {
			if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
				resp.sendRedirect("/lista");
			} else {
				resp.sendRedirect("/login.jsp");
			}
		}
	}

}
