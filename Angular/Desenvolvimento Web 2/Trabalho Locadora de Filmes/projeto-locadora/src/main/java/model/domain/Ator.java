package model.domain;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ator {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long idAtor;
	 
	 private String nome;
}
