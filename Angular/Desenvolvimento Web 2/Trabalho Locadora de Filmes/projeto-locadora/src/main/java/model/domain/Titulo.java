package model.domain;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Titulo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long idTitulo;
	 
	 private String nome;
	 
	 private String ano;

	 private String categoria;
	 
	 private String sinopse;
	 
	 @ManyToOne
	 @JoinColumn(name = "idDiretor")
	 private Diretor diretor;
	 
	 @ManyToOne
	 @JoinColumn(name = "idClasse")
	 private Classe classe;
	 
	 @ManyToMany
	 @JoinTable(name="ator_titulo", joinColumns= {@JoinColumn(name="idTitulo")}, inverseJoinColumns= {@JoinColumn(name="idAtor")})
	 private List<Ator> atores;
}
