package desafio.spring.rest;

import java.util.Set;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.spring.persistence.dto.base.MessageApiDTO;
import desafio.spring.persistence.dto.base.PaginationDTO;
import desafio.spring.persistence.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * @author acacio.leal
 * Controller Pessoa
 */
@RestController
@Api(value = "PESSOA") 
@RequestMapping("pessoa")
@CrossOrigin
public class PessoaController {
	@Autowired
	private PessoaService service;
	
	@GetMapping
	@ApiOperation(value = "Operação para consultar Pessoa por filtros", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = SearchFilterPessoaDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public PaginationDTO<SearchFilterPessoaDTO> retrievePessoa(@Valid SearchFilterPessoaDTO dto) {
		return service.retrievePessoa(dto);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Operação para consultar todos as Pessoa sem filtro", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = SearchFilterPessoaDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public Set<SearchFilterPessoaDTO> retrievePessoa() {
		return service.retrievePessoa();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Operação para consultar todos as Pessoa sem filtro", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = SearchFilterPessoaDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public SearchFilterPessoaDTO retrievePessoaById(@PathVariable Long id) {
		return service.retrievePessoaById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Operação para Cadastrar Pessoa", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = MessageApiDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public MessageApiDTO createPessoa(@RequestBody @Valid SearchFilterPessoaDTO dto) {
		return service.createPessoa(dto);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value = "Operação para Cadastrar Pessoa", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = MessageApiDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public MessageApiDTO putPessoa(@PathVariable Long id, @RequestBody @Valid SearchFilterPessoaDTO dto) {
		return service.putPessoa(id, dto);
	}
}
