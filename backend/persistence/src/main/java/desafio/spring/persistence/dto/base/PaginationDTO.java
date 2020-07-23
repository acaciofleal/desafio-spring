package desafio.spring.persistence.dto.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author acacio.leal
 * DTO base para retorno paginado das Pessoas registradas em banco
 */
public class PaginationDTO<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1901750565792336182L;
	
	private Long totalNumber;
    private List<T> items;

    public PaginationDTO() {
        super();
    }

    public PaginationDTO(Long totalNumber, List<T> items) {
        this.totalNumber = totalNumber;
        this.items = items;
    }

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
