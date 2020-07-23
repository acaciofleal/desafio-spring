package desafio.spring.persistence.dto.base;

import static desafio.spring.persistence.constants.Constants.DEFAULT_NUMBER_PAGE;
import static desafio.spring.persistence.constants.Constants.DEFAULT_ORDER;
import static desafio.spring.persistence.constants.Constants.ITEMS_PER_PAGE;

import java.io.Serializable;

/**
 * @author acacio.leal
 * DTO de paginação para requisição por filtros de Pessoa
 */

public class PaginationFilterDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3481335698095727281L;

	private Integer itemsPerPage = ITEMS_PER_PAGE;
		
	private Integer pageNumber = DEFAULT_NUMBER_PAGE;
		
	private String orderBy = DEFAULT_ORDER;

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


	
}
