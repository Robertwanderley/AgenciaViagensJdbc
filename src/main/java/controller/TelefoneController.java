package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Telefone;
import models.dao.TelefoneDao;

/**
 * Servlet implementation class TelefoneController
 */
@WebServlet("/Telefone")
public class TelefoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelefoneController() {
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
		
		Telefone telefone = new Telefone();
		TelefoneDao telefonedao = new TelefoneDao();
		RequestDispatcher rd = null;
		
		//telefone.setIdCliente(Integer.parseInt(request.getParameter("txtId")));
		telefone.setCelular(request.getParameter("txtCel"));
		telefone.setFixo(request.getParameter("txtFix"));
	
		try {
			telefonedao.cadastrar(telefone);
			request.setAttribute("telefone", telefone);
			rd = request.getRequestDispatcher("Sucesso.jsp");
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
