package it.prova.dottore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.dottore.model.Dottore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottoreDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;
	private Boolean inVisita;
	private Boolean inServizio;

	public DottoreDTO(String codiceDottore, String codFiscalePazienteAttualmenteInVisita, Boolean inVisita,
			Boolean inServizio) {
		this.codiceDottore = codiceDottore;
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}

	public DottoreDTO(Long id, String nome, String cognome, String codiceDottore,
			String codFiscalePazienteAttualmenteInVisita, Boolean inVisita, Boolean inServizio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDottore = codiceDottore;
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}

	public DottoreDTO(String nome, String cognome, String codiceDottore) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDottore = codiceDottore;
	}

	public Dottore buildDottoreModel() {
		return new Dottore(this.id, this.nome, this.cognome, this.codiceDottore,
				this.codFiscalePazienteAttualmenteInVisita, this.inVisita, this.inServizio);
	}

	public static DottoreDTO buildDTOFromDottoreModel(Dottore model) {
		return new DottoreDTO(model.getId(), model.getNome(), model.getCognome(), model.getCodiceDottore(),
				model.getCodFiscalePazienteAttualmenteInVisita(), model.getInVisita(), model.getInServizio());
	}

	public static DottoreDTO buildDTOAnagraficaFromDottoreModel(Dottore model) {
		return new DottoreDTO(model.getNome(), model.getCognome(), model.getCodiceDottore());
	}

	public static DottoreDTO buildDTOStatoFromDottoreModel(Dottore model) {
		return new DottoreDTO(model.getCodiceDottore(), model.getCodFiscalePazienteAttualmenteInVisita(),
				model.getInVisita(), model.getInServizio());
	}
}
