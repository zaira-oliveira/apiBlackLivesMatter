package br.com.afrodev.apiBlackLivesMatter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afrodev.apiBlackLivesMatter.models.Casos;

//Interface estende o JpaRepository que possui vários métodos para fazer persistência em banco
//E possível criar métodos conforme necessidade de busca

public interface CasosRepository extends JpaRepository<Casos, Long>{
	
	Optional<Casos> findByAno(int ano);
	Optional<Casos> findByMes(String mes);
	Optional<Casos> findByCidade(String cidade);

}
