package br.com.afrodev.apiBlackLivesMatter.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus //Marca como classe de Status de Resposta à requisição
public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 5056037223675491315L; //especificação do JAVA pede que seja desse jeito.

	public ResourceNotFound(String message) {
		super(message);
	}

}
