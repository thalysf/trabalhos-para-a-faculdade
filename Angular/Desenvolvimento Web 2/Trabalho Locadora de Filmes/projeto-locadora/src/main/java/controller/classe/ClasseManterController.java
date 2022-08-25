package controller.classe;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.ClasseApl;
import model.domain.Classe;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/ClasseManterController")
public class ClasseManterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseApl classeApl;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasseManterController() {
    	this.classeApl = new ClasseApl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("classes", classeApl.getAllClasses());
		RequestDispatcher dispatcher = request.getRequestDispatcher("classe.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			cadastrar(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "";
		
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		String prazoDevolucao = request.getParameter("prazoDevolucao");
		
        Classe classe = new Classe();
        classe.setNome(nome);
        try
        {
        	classe.setValor(Double.valueOf(valor));
     		classe.setPrazoDevolucao(formatter.parse(prazoDevolucao));
        }
       catch(Exception e)
        {
    	   msg += "Falha na formatação dos dados, valores recebidos inválidos!";
        }

        if(isValidClasse(classe))
        {
        	classeApl.inserir(classe);
        	request.setAttribute("mensagem", "Classe salva com sucesso!");
        	request.setAttribute("cor", "green");
        }
        else
        {
        	request.setAttribute("mensagem", msg + " Classe inválida, por favor preencha os campos corretamente!<br/>");
        	request.setAttribute("cor", "red");
        }
        request.setAttribute("classes", classeApl.getAllClasses());
		RequestDispatcher dispatcher = request.getRequestDispatcher("classe.jsp");
	    dispatcher.forward(request, response);
    }

	private boolean isValidClasse(Classe classe) {
		if(classe.getNome().isEmpty() || classe.getValor() == null || classe.getPrazoDevolucao() == null)
			return false;
		
		return true;
	}
}
