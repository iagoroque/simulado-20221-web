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

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioDAO udao = new UsuarioDAO();

		String nula = "";
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario user = new Usuario(login, senha);
		
		if ((login.equals(nula)) || (senha.equals(nula))) {
			resp.sendRedirect("/cadastro.jsp");
		} else {
			udao.save(user);
			resp.sendRedirect("/lista.jsp");
		}
	}

}
