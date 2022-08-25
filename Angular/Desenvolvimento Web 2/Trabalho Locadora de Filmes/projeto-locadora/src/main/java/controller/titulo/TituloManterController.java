package controller.titulo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import model.domain.Ator;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Titulo;

/**
 * Servlet implementation class TituloInserirController
 */
@WebServlet("/TituloManterController")
public class TituloManterController extends HttpServlet {
	private DiretorApl diretorApl;
	private ClasseApl classeApl;
	private TituloApl tituloApl;
	private AtorApl atorApl;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TituloManterController() {
        this.diretorApl = new DiretorApl();
        this.classeApl = new ClasseApl();
        this.tituloApl = new TituloApl();
        this.atorApl = new AtorApl();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("diretores", diretorApl.getAllDiretores());
		request.setAttribute("classes", classeApl.getAllClasses());
		request.setAttribute("atores", atorApl.getAllAtores());
		request.setAttribute("titulos", tituloApl.getAllTitulos());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("titulo.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			manter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void manter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idTitulo = request.getParameter("idTitulo");
		String ano = request.getParameter("ano");
		String nome = request.getParameter("nome");
		String sinopse = request.getParameter("sinopse");
		String categoria = request.getParameter("categoria");
		Long idDiretor = Long.valueOf(request.getParameter("idDiretor"));
		Long idClasse = Long.valueOf(request.getParameter("idClasse"));
		
        Titulo titulo = new Titulo();
        titulo.setAno(ano);
        titulo.setNome(nome);
        titulo.setSinopse(sinopse);
        titulo.setCategoria(categoria);
        
        Diretor diretor = new Diretor();
        diretor.setIdDiretor(idDiretor);
       
        Classe classe = new Classe();
        classe.setIdClasse(idClasse);
        
        List<Ator> atores = new ArrayList<>();
        System.out.println(titulo);
        
        for(int i = 0; i < atorApl.getAllAtores().size(); i++)
		{
        	String idAtor = request.getParameter("ator" + i);
        	System.out.println(idAtor);
         	Ator ator = new Ator();
			if(idAtor != null)
			{
				ator.setIdAtor(Long.valueOf(idAtor));
				atores.add(ator);
			}	
		}
        
        titulo.setDiretor(diretor);
        titulo.setClasse(classe);
        titulo.setAtores(atores);

        if(isValidTitulo(titulo))
        {
        	if(idTitulo == null || idTitulo.equals(""))
        	{
        		tituloApl.inserir(titulo);
            	request.setAttribute("mensagem", "Título salvo com sucesso!");
        	}
        	else
        	{
        		titulo.setIdTitulo(Long.valueOf(idTitulo));
        		tituloApl.alterar(titulo);
            	request.setAttribute("mensagem", "Título alterado com sucesso!");
        	}
        	
        	request.setAttribute("cor", "green");
        }
        else
        {
        	request.setAttribute("mensagem", "Título inválido, por favor preencha os campos corretamente!");
        	request.setAttribute("cor", "red");
        }
        
		doGet(request, response);
    }
	
	private boolean isValidTitulo(Titulo titulo) {
		if(titulo.getAno().isEmpty() || titulo.getCategoria().isEmpty() || titulo.getNome().isEmpty() || 
				titulo.getDiretor().getIdDiretor() == null|| titulo.getClasse().getIdClasse() == null || titulo.getAtores().isEmpty())
		{
			return false;
		}
		return true;
	}
}
