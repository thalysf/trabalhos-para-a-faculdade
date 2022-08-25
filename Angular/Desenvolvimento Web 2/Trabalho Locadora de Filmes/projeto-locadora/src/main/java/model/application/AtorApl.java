package model.application;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.dao.AtorDAO;
import model.domain.Ator;

@NoArgsConstructor
@Data
public class AtorApl {
	private AtorDAO atorDAO = new AtorDAO();
	
	public void excluir(Ator ator)
	{
		atorDAO.excluir(ator);
	}
	public List<Ator> getAllAtores()
	{
		return atorDAO.listarTodos();
	}
	public void inserir(Ator ator) {
		atorDAO.inserir(ator);
	}
}
