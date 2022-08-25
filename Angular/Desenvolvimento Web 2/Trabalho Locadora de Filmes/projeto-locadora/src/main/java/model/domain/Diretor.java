package model.domain;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diretor {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long idDiretor;
	 
	 private String nome;
}
