package br.com.afrodev.apiBlackLivesMatter.services;

import java.util.List;

import br.com.afrodev.apiBlackLivesMatter.models.Casos;

public interface CasosServices {
	
	//assinaturas de métodos

	Casos criaCaso(Casos caso);
	Casos atualizaCaso(Casos caso);
	void deletaCaso(long id);
	
	List<Casos> pegaTodosCasos();
	
	Casos peloId(long id);
	Casos peloAno(int ano);
	Casos peloMes(String mes);
	Casos pelaCidade(String cidade);

}
