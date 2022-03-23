package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cliente;
import models.dao.ClienteDao;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = { "/Cadastrar" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		ClienteDao clientedao = new ClienteDao();
		RequestDispatcher rd = null;
		
		cliente.setNome(request.getParameter("txtNome"));
		cliente.setSobrenome(request.getParameter("txtSobre"));
		cliente.setEmail(request.getParameter("txtEmail"));
		cliente.setCpf(request.getParameter("txtCpf"));
	
		try {
			clientedao.cadastrar(cliente);
			request.setAttribute("cliente", cliente);
			rd = request.getRequestDispatcher("ComprarPassagem.jsp");
			System.out.println("Operação bem sucedida");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("Falhou.jsp");
			System.out.println("Operação falhou");
		}
		finally {
			rd.forward(request, response);
		}
		
	}

}
