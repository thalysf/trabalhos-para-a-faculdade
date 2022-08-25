package model.application;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.dao.ClasseDAO;
import model.domain.Classe;

@NoArgsConstructor
@Data
public class ClasseApl {
	private ClasseDAO classeDAO = new ClasseDAO();

	public void inserir(Classe classe) {
		classeDAO.inserir(classe);
	}
	public List<Classe> getAllClasses()
	{
		return classeDAO.listarTodos();
	}
}
