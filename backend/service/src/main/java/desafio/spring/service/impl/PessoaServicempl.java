package desafio.spring.service.impl;

import static desafio.spring.service.constants.ServiceConstants.ENTITY_POST;
import static desafio.spring.service.constants.ServiceConstants.ENTITY_PUT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import desafio.spring.dto.base.MessageApiDTO;
import desafio.spring.dto.base.PaginationDTO;
import desafio.spring.dto.pessoa.SearchFilterPessoaDTO;
import desafio.spring.persistence.PessoaDAO;
import desafio.spring.persistence.jpa.model.Pessoa;
import desafio.spring.service.PessoaService;
import desafio.spring.service.exception.BusinessException;
import desafio.spring.service.util.ResponseUtil;


/**
 * 
 * @author acacio.leal
 * Classe de implementacao das regras de negocio
 *
 */
@Service
public class PessoaServicempl implements PessoaService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public PaginationDTO<SearchFilterPessoaDTO> retrievePessoa(SearchFilterPessoaDTO dto) {
		List<SearchFilterPessoaDTO> pessoas = new ArrayList<>();		
		Page<Pessoa> pageReports = pessoaDAO.retrievePessoa(dto);

		if(pageReports.isEmpty()) {
			throw new BusinessException("Não foram encontrados registros para os filtros informados.");
		}
		pageReports.stream().forEach(item -> pessoas.add(convert(item)));

		return new PaginationDTO<>(pageReports.getTotalElements(), pessoas);
	}

	@Override
	public Set<SearchFilterPessoaDTO> retrievePessoa() {
		Set<SearchFilterPessoaDTO> dto = new HashSet<>();
		Iterator<Pessoa> iterator = pessoaDAO.findAll().iterator();
		while(iterator.hasNext()) {
			dto.add(convert(iterator.next()));
		}
		if(dto.isEmpty()) {
			throw new BusinessException("Não foram encontrados registros para Pessoa na base de dados.");
		}
		return dto;
	}

	@Override
	public SearchFilterPessoaDTO retrievePessoaById(Long id) {
		return pessoaDAO.find(id).map(item -> convert(item))
				   .orElseThrow(() -> new BusinessException("Pessoa não encontrada com ID informado."));
	}

	@Override
	public MessageApiDTO createPessoa(SearchFilterPessoaDTO dto) {
		Pessoa pessoa = convert(dto);
		pessoa.setIdPessoa(null);
		return ResponseUtil.mountResponse(pessoaDAO.save(pessoa), ENTITY_POST);
	}

	@Override
	public MessageApiDTO putPessoa(Long id, SearchFilterPessoaDTO dto) {
		if(!pessoaDAO.find(id).isPresent()) {
			throw new BusinessException("CNES não encontrado com ID informado.");
		}
		
		Pessoa pessoa = convert(dto);
		pessoa.setIdPessoa(id);

		return ResponseUtil.mountResponse(pessoaDAO.save(pessoa), ENTITY_PUT);
	}

	
	private SearchFilterPessoaDTO convert(Pessoa pessoa) {
		return modelMapper.map(pessoa, SearchFilterPessoaDTO.class);
	}
	
	private Pessoa convert(SearchFilterPessoaDTO dto) {
		return modelMapper.map(dto, Pessoa.class);
	}
}
