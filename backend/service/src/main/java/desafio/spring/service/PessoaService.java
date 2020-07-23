package desafio.spring.service;

import java.util.Set;

import desafio.spring.dto.base.MessageApiDTO;
import desafio.spring.dto.base.PaginationDTO;
import desafio.spring.dto.pessoa.SearchFilterPessoaDTO;

/**
 * 
 * @author acacio.leal
 * Interface de Servicos
 *
 */
public interface PessoaService {

	/**
	 * Consultar Pessoa cadastrados em memory database (H2) a partir de vários filtros
	 * 
	 * @return {@link PaginationDTO<SearchFilterPessoaDTO>} - Pessoa em memory database
	 * @throws BusinessException 
	 */
	public PaginationDTO<SearchFilterPessoaDTO> retrievePessoa(SearchFilterPessoaDTO dto);

	/**
	 * Consultar Pessoa cadastradas em memory database (H2) - All
	 * 
	 * @return {@link Set<SearchFilterPessoaDTO>} - Pessoa em memory database
	 * @throws BusinessException 
	 */
	public Set<SearchFilterPessoaDTO> retrievePessoa();

	/**
	 * Consultar Pessoa por ID
	 * 
	 * @return {@link ViewPessoaDTO} - Pessoa em memory database por ID
	 * @throws BusinessException 
	 */
	public SearchFilterPessoaDTO retrievePessoaById(Long id);

	
	/**
	 * Criar Pessoa a partir de dados inseridos
	 * 
	 * @return {@link MessageApiDTO} - Retorno com mensagem estática e ID gerado para item criado
	 * @throws BusinessException 
	 */
	public MessageApiDTO createPessoa(SearchFilterPessoaDTO dto);

	/**
	 * Atualizar (totalmente ou parcialmente) Pessoa a partir de dados inseridos
	 * 
	 * @return {@link MessageApiDTO} - Retorno com mensagem estática e ID gerado para item atualizado
	 * @throws BusinessException 
	 */
	public MessageApiDTO putPessoa(Long id, SearchFilterPessoaDTO dto);

}
