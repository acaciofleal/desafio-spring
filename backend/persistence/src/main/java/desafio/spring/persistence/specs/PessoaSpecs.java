package desafio.spring.persistence.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import desafio.spring.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.persistence.jpa.model.Pessoa;

/**
 * 
 * @author acacio.leal
 *
 */
public final class PessoaSpecs {
	
	private static final String NOME = "nome";	
	private static final String CPF = "cpf";
	
	
	public static Specification<Pessoa> filterSpecs(SearchFilterPessoaDTO dto) {
		return new Specification<Pessoa>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -3107153401151357235L;

			public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {

				List<Predicate> predicates = new ArrayList<Predicate>();						
			
				definirPredicados(predicates, builder, dto, root);

				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			private void definirPredicados(List<Predicate> predicates, CriteriaBuilder builder,
					SearchFilterPessoaDTO dto, Root<Pessoa> root) {
						
				  if(dto.getNome() != null) { 
					  predicates.add(builder.equal(root.get(NOME), dto.getNome())); 
				  }
				  
				  if(dto.getCpf() != null) { 
					  predicates.add(builder.like(root.get(CPF), dto.getCpf()));
				  }

			}

		};
	}
}
