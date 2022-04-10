package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
	
	private UsuarioDAO udao = new UsuarioDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Para fazer uma escolha de papeis la no cadastro tambem, fazer um codigo no jps tambem.
		List<String> lista = new ArrayList<>();
		lista.add("DEV");
		lista.add("BD");
		lista.add("DEVOPS");
		req.setAttribute("papeis", lista);
		req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vazia = "";
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario user = new Usuario(login, senha);
		
		if ((login.equals(vazia)) || (senha.equals(vazia))) {
			resp.sendRedirect("/cadastro.jsp");
		} else {
			udao.save(user);
			resp.sendRedirect("/lista");
		}
	}

}
