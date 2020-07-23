package desafio.spring.persistence.dto.pessoa;

import desafio.spring.persistence.dto.base.PaginationFilterDTO;

/**
 * 
 * @author acacio.leal
 * DTO dos filtros de pesquisa de Pessoa
 */


public class SearchFilterPessoaDTO extends PaginationFilterDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -170131432084492408L;

	private String nome;
	
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
