package desafio.spring.dto.pessoa;

import java.util.Date;

import desafio.spring.dto.base.PaginationFilterDTO;

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
	
	private Date dataNascimento;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
