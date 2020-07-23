package desafio.spring.service.util;

import org.springframework.http.HttpStatus;

import desafio.spring.persistence.dto.base.MessageApiDTO;

/**
 * @author acacio.leal
 * Classe de utils para montar resposta das operações de API
 */
public final class ResponseUtil {

	public static MessageApiDTO mountResponse(Long id, String mensagem) {
		return new MessageApiDTO(id, HttpStatus.OK.value(), mensagem);
	}
	
}
