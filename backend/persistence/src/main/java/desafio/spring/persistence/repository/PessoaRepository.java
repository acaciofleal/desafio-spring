package desafio.spring.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import desafio.spring.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.persistence.jpa.model.Pessoa;
import desafio.spring.persistence.specs.PessoaSpecs;

/**
 * @author acacio.leal
 * Repositório para buscar por Specs/Predicates (filtros) e operações default de CRUD
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> { 
	default Page<Pessoa> retrievePessoa(SearchFilterPessoaDTO dto, Pageable pageable){
		return findAll(PessoaSpecs.filterSpecs(dto), pageable);
	};
}
