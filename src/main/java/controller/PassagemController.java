package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Passagem;
import models.dao.PassagemDao;

/**
 * Servlet implementation class PassagemController
 */
@WebServlet("/Passagem")
public class PassagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassagemController() {
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
		
		Passagem passagem = new Passagem();
		PassagemDao passagemdao = new PassagemDao();
		RequestDispatcher rd = null;
		
		//passagem.setIdCliente(Integer.parseInt(request.getParameter("txtId")));
		passagem.setEmbarque(request.getParameter("txtEmb"));
		passagem.setDesembarque(request.getParameter("txtDesem"));
		passagem.setPreco(Double.parseDouble(request.getParameter("txtPreco")) );
	
		try {
			passagemdao.comprar(passagem);
			request.setAttribute("passagem", passagem);
			rd = request.getRequestDispatcher("CadastrarTelefone.jsp");
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
