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
@WebServlet("/AtorManterController")
public class AtorManterController extends HttpServlet {
	private AtorApl atorApl;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtorManterController() {
    	this.atorApl = new AtorApl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("atores", atorApl.getAllAtores());
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("ator.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cadastrar(request, response);
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nome = request.getParameter("nome");

        Ator ator = new Ator();
        ator.setNome(nome);
        
        
	    if(isValidAtor(ator))
        {
	    	atorApl.inserir(ator);
        	request.setAttribute("mensagem", "Ator salvo com sucesso!");
        	request.setAttribute("cor", "green");
        }
        else
        {
        	request.setAttribute("mensagem", "Ator inválido, por favor preencha os campos corretamente!");
        	request.setAttribute("cor", "red");
        }
        
	    
	    request.setAttribute("atores", atorApl.getAllAtores());
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("ator.jsp");
	    dispatcher.forward(request, response);
    }

	private boolean isValidAtor(Ator ator) {
		if(ator.getNome().isEmpty())
			return false;
		
		return true;
	}
}
