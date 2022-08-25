package model.application;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.dao.DiretorDAO;
import model.domain.Diretor;

@NoArgsConstructor
@Data
public class DiretorApl {
	private DiretorDAO diretorDAO = new DiretorDAO();

	public void inserir(Diretor diretor) {
		diretorDAO.inserir(diretor);
	}
	public List<Diretor> getAllDiretores()
	{
		return diretorDAO.listarTodos();
	}
}
