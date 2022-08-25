package controller.ator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.AtorApl;
import model.domain.Ator;

/**						
 * Servlet implementation class AtorController
 */
@WebServlet("/AtorDeletarController")
public class AtorDeletarController extends HttpServlet {
	private AtorApl atorApl;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtorDeletarController() {
    	this.atorApl = new AtorApl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ator = request.getParameter("idAtor");
		excluir(request, response, ator);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response, String idAtor) throws IOException, ServletException {
	
        Ator ator = new Ator();
        ator.setIdAtor(Long.valueOf(idAtor));
        
        atorApl.excluir(ator);
        
        
    	request.setAttribute("mensagem", "Ator excluído com sucesso!");
    	request.setAttribute("cor", "green");
    	
	    request.setAttribute("atores", atorApl.getAllAtores());
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("ator.jsp");
	    dispatcher.forward(request, response);
    }
}
