package desafio.spring.persistence.dao.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import desafio.spring.persistence.dao.PessoaDAO;
import desafio.spring.persistence.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.persistence.model.Pessoa;
import desafio.spring.persistence.repository.PessoaRepository;

/**
 * 
 * @author acacio.leal
 * Classe que implementa o DAO
 *
 */
public class PessoaDAOImpl implements PessoaDAO {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	private static final String SORT_DEFAULT_COLUMN = "nome";
	
	@Override
	public boolean save(Set<Pessoa> pessoa) {
		pessoaRepository.saveAll(pessoa);
		return true;
	}

	@Override
	public Long save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa).getIdPessoa();
	}

	@Override
	public boolean removePessoa(Long id) {
		pessoaRepository.deleteById(id);
		return true;
	}

	@Override
	public Optional<Pessoa> find(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public Page<Pessoa> retrievePessoa(SearchFilterPessoaDTO dto) {
		return pessoaRepository.retrievePessoa(dto, PageRequest.of(dto.getPageNumber() - 1, dto.getItemsPerPage(), Sort.by(Direction.valueOf(dto.getOrderBy()), SORT_DEFAULT_COLUMN)));
	}

	@Override
	public Iterable<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

}
