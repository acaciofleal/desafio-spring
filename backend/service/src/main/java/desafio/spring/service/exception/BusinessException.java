package desafio.spring.service.exception;

/**
 * @author acacio.leal
 * Exceção de negócio (camada de serviços)
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 2604295284186360092L;
	
	public BusinessException(String message) {
		super(message);
	}

}
