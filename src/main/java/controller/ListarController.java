package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cliente;
import models.dao.ClienteDao;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/ListarController")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cliente> clientes;
		try {
			clientes = ClienteDao.Listar();
			request.setAttribute("clientes", clientes);
			RequestDispatcher resquesDispatcher = request.getRequestDispatcher("Lista.jsp");
			resquesDispatcher.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Cliente cliente = new Cliente();
			ClienteDao clientedao = new ClienteDao();
			
			cliente.setNome(request.getParameter("txtNome"));
			cliente.setSobrenome(request.getParameter("txtSobre"));
			cliente.setEmail(request.getParameter("txtEmail"));
			cliente.setCpf(request.getParameter("txtCpf"));
			clientedao.alterar(cliente, request.getParameter("txtAntigoCpf"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
