package model.domain;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classe {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long idClasse;

	 private String nome;
	 
	 private Double valor;
	 
	 private Date prazoDevolucao;
}
