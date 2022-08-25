package model.application;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.dao.TituloDAO;
import model.domain.Titulo;

@NoArgsConstructor
@Data
public class TituloApl {
	private TituloDAO tituloDAO = new TituloDAO();
	
	public void excluir(Titulo titulo) {
		tituloDAO.excluir(titulo);
	}

	public void inserir(Titulo titulo) {
		tituloDAO.inserir(titulo);
	}
	
	public void alterar(Titulo titulo) {
		tituloDAO.alterar(titulo);
	}
	
	public List<Titulo> getAllTitulos()
	{
		return tituloDAO.listarTodos();
	}
}
