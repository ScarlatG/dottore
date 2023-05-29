package it.prova.dottore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.repository.DottoreRepository;

@Service
@Transactional
public class DottoreServiceImpl implements DottoreService {

	@Autowired
	private DottoreRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Dottore> findAll() {
		return (List<Dottore>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dottore findById(Long id) {
		return repository.findById(null).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Dottore findByCodice(String codice) {
		return repository.findByCodiceDottore(codice).stream().findFirst().orElse(null);
	}

	@Override
	public Dottore inserisciNuovo(Dottore input) {
		// TODO se l'id non è null lancio eccezione
		return repository.save(null);
	}

	@Override
	public Dottore aggiornaStato(Dottore input) {
		Dottore reloaded = repository.findByCodiceDottore(input.getCodiceDottore()).stream().findFirst().orElse(null);
		// gestire dottore non disponibile
		if (input.getInServizio() != null)
			reloaded.setInServizio(input.getInServizio());
		if (input.getInVisita() != null) {
			reloaded.setInVisita(input.getInVisita());
			if (input.getCodFiscalePazienteAttualmenteInVisita() != null && input.getInVisita())
				reloaded.setCodFiscalePazienteAttualmenteInVisita(input.getCodFiscalePazienteAttualmenteInVisita());
		}
		return repository.save(reloaded);
	}

	@Override
	public Dottore aggiornaAnagrafica(Dottore input) {
		Dottore reloaded = repository.findByCodiceDottore(input.getCodiceDottore()).stream().findFirst().orElse(null);
		// gestire dottore non disponibile
		if (!input.getNome().isBlank())
			reloaded.setNome(input.getNome());
		if (!input.getCognome().isBlank())
			reloaded.setCognome(input.getCognome());
		return repository.save(reloaded);
	}

	@Override
	public void rimuovi(Long id) {
		// TODO se non trovo l'id lancio eccezione
		repository.deleteById(id);
	}

	@Override
	public void terminaVisita(String codiceDottore) {
		Dottore d = repository.findByCodiceDottore(codiceDottore).stream().findFirst().orElse(null);
		// gestire dottore non trovato
		d.setInVisita(false);
		d.setCodFiscalePazienteAttualmenteInVisita(null);
		repository.save(d);
	}
}