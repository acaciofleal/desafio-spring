package desafio.spring.service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author acacio.leal
 * Classe para inicialização do ModelMapper
 */
@Configuration
public class MapperConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();	    
	    return modelMapper;
	    
	}

	
	
}
