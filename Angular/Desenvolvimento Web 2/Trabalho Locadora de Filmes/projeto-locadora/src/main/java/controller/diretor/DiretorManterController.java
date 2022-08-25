package controller.diretor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.DiretorApl;
import model.domain.Diretor;

/**
 * Servlet implementation class DiretorController1
 */
@WebServlet("/DiretorManterController")
public class DiretorManterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DiretorApl classeApl;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiretorManterController() {
    	classeApl = new DiretorApl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("diretores", classeApl.getAllDiretores());
		RequestDispatcher dispatcher = request.getRequestDispatcher("diretor.jsp");
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

        Diretor diretor = new Diretor();
        diretor.setNome(nome);
        
        if(isValidDiretor(diretor))
        {
        	classeApl.inserir(diretor);
        	request.setAttribute("mensagem", "Diretor salvo com sucesso!");
        	request.setAttribute("cor", "green");
        }
        else
        {
        	request.setAttribute("mensagem", "Diretor inválido, por favor preencha os campos corretamente!");
        	request.setAttribute("cor", "red");
        }
        request.setAttribute("diretores", classeApl.getAllDiretores());
		RequestDispatcher dispatcher = request.getRequestDispatcher("diretor.jsp");
	    dispatcher.forward(request, response);
    }

	private boolean isValidDiretor(Diretor diretor) {
		if(diretor.getNome().isEmpty())
			return false;
		
		return true;
	}
}
