package it.prova.dottore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dottore")
public class Dottore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "codiceDottore")
	private String codiceDottore;
	@Column(name = "codFiscalePazienteAttualmenteInVisita")
	private String codFiscalePazienteAttualmenteInVisita;
	@Column(name = "inVisita")
	private Boolean inVisita;
	@Column(name = "inServizio")
	private Boolean inServizio;
	
	
}
