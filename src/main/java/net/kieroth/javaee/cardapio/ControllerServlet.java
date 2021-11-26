package net.kieroth.javaee.cardapio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PratoDAO pratoDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        pratoDAO = new PratoDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertPrato(request, response);
                break;
            case "/delete":
                deletePrato(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updatePrato(request, response);
                break;
            default:
                listPrato(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listPrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Prato> listPrato = pratoDAO.listAllPratos();
        request.setAttribute("listPrato", listPrato);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PratoList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("PratoForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Prato existingPrato = pratoDAO.getPrato(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PratoForm.jsp");
        request.setAttribute("prato", existingPrato);
        dispatcher.forward(request, response);
 
    }
 
    private void insertPrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        float preco = Float.parseFloat(request.getParameter("preco"));
 
        Prato newPrato = new Prato(nome, ingredientes, preco);
        pratoDAO.insertPrato(newPrato);
        response.sendRedirect("list");
    }
 
    private void updatePrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        float preco = Float.parseFloat(request.getParameter("preco"));
 
        Prato prato = new Prato(id, nome, ingredientes, preco);
        pratoDAO.updatePrato(prato);
        response.sendRedirect("list");
    }
 
    private void deletePrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Prato prato = new Prato(id);
        pratoDAO.deletePrato(prato);
        response.sendRedirect("list");
 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
