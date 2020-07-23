package desafio.spring.persistence.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;

import desafio.spring.persistence.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.persistence.model.Pessoa;

/**
 * 
 * @author acacio.leal
 *
 */
public interface PessoaDAO {

	/**
	 * Salvar em lote Pessoa
	 * 
	 * @return {@link Boolean} - TRUE para sucesso ao salvar
	 */
	public boolean save(Set<Pessoa> pessoa);

	/**
	 * Salvar em Pessoa
	 * 
	 * @return {@link Long} - ID do Pessoa persistido
	 */
	public Long save(Pessoa pessoa);

	/**
	 * Remover Pessoa por ID informado
	 * 
	 * @return {@link Boolean} - TRUE para sucesso ao remover
	 */
	public boolean removePessoa(Long id);
	
	/**
	 * Recuperar Pessoa por ID informado
	 * 
	 * @return {@link Optional<Pessoa>}
	 */
	public Optional<Pessoa> find(Long id);
	
	/**
	 * Recuperar Pessoa por filtros informados. Paginado.
	 * 
	 * @return {@link Page<Pessoa>}
	 */
	public Page<Pessoa> retrievePessoa(SearchFilterPessoaDTO dto);

	/**
	 * Recuperar todos as Pessoas em base da dados.
	 * 
	 * @return {@link Iterable<Pessoa>}
	 */
	Iterable<Pessoa> findAll();
}
