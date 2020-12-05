package br.com.afrodev.apiBlackLivesMatter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.afrodev.apiBlackLivesMatter.exceptions.ResourceNotFound;
import br.com.afrodev.apiBlackLivesMatter.models.Casos;
import br.com.afrodev.apiBlackLivesMatter.repository.CasosRepository;

@Service
@Transactional
public class CasosServicesImpl implements CasosServices {

	@Autowired //injetar
	private CasosRepository casosRepository;

	@Override //get
	public List<Casos> pegaTodosCasos() {
		return this.casosRepository.findAll();
	}
	
	@Override //post
	public Casos criaCaso(Casos caso){
		caso.setId(null);
		return casosRepository.save(caso);
	}

	@Override
	public Casos atualizaCaso(Casos caso) {
		Optional<Casos> casosDb = this.casosRepository.findById(caso.getId());	
		
		if(casosDb.isPresent()) {
			Casos atualiza = casosDb.get();
			atualiza.setId(caso.getId());
			atualiza.setNome(caso.getNome());
			atualiza.setIdade(caso.getIdade());
			atualiza.setCidade(caso.getCidade());
			atualiza.setMes(caso.getMes());
			atualiza.setAno(caso.getAno());
			casosRepository.save(atualiza);
			return atualiza;
		} else {
			throw new ResourceNotFound("Registro não encontrado com o ID: " + caso.getId());

		}
	}

	@Override
	public void deletaCaso(long id) {
		
		Optional<Casos> casosDb = this.casosRepository.findById(id);

		if(casosDb.isPresent()) {
			this.casosRepository.delete(casosDb.get());
		}else {
			throw new ResourceNotFound("Registro não encontrado com o ID: " + id);		
		}
	}

	@Override
	public Casos peloId(long id) { //getId
		Optional<Casos> casosDb = this.casosRepository.findById(id);
		if(casosDb.isPresent()) {
			return casosDb.get();
		}else {
			throw new ResourceNotFound("Registro não encontrado com o ID: " + id);
		}
	}

	@Override
	public Casos peloAno(int ano) {
		
		Optional<Casos> casosDb = casosRepository.findByAno(ano);
		if(casosDb.isPresent()) {
			return casosDb.get();
		}else {
			throw new ResourceNotFound("Registro não encontrado com o ano: " + ano);
		}
		
	}

	@Override
	public Casos peloMes(String mes) {
		Optional<Casos> casosDb = this.casosRepository.findByMes(mes);
		if(casosDb.isPresent()) {
			return casosDb.get();
		}else {
			throw new ResourceNotFound("Registro não encontrado com o mes: " + mes);
		}
	}

	@Override
	public Casos pelaCidade(String cidade) {
		Optional<Casos> casosDb = this.casosRepository.findByCidade(cidade);
		if(casosDb.isPresent()) {
			return casosDb.get();
		}else {
			throw new ResourceNotFound("Registro não encontrado com a cidade: " + cidade);
		}
	}

}
