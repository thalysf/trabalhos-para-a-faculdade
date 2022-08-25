package controller.titulo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.application.AtorApl;
import model.application.ClasseApl;
import model.application.DiretorApl;
import model.application.TituloApl;
import model.domain.Titulo;

/**
 * Servlet implementation class TituloDeletarController
 */
@WebServlet("/TituloDeletarController")
public class TituloDeletarController extends HttpServlet {
	private DiretorApl diretorApl;
	private ClasseApl classeApl;
	private TituloApl tituloApl;
	private AtorApl atorApl;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TituloDeletarController() {
        this.diretorApl = new DiretorApl();
        this.classeApl = new ClasseApl();
        this.tituloApl = new TituloApl();
        this.atorApl = new AtorApl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excluir(request, response, request.getParameter("idTitulo"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response, String idTitulo) throws IOException, ServletException {
		
        Titulo titulo = new Titulo();
        titulo.setIdTitulo(Long.valueOf(idTitulo));
        
        tituloApl.excluir(titulo);
        
        
    	request.setAttribute("mensagem", "Título excluído com sucesso!");
    	request.setAttribute("cor", "green");
    	
    	request.setAttribute("diretores", diretorApl.getAllDiretores());
		request.setAttribute("classes", classeApl.getAllClasses());
		request.setAttribute("atores", atorApl.getAllAtores());
		request.setAttribute("titulos", tituloApl.getAllTitulos());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("titulo.jsp");
	    dispatcher.forward(request, response);
    }
}
