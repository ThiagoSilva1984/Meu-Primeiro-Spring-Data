//essa é uma entidade

package br.com.alura.springdata.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // com essa anotação estou dizendo para o spring essa
		// classe é uma entidade, ou seja que o spring crie uma entidade a partir dessa
		// classe
@Table(name = "cargos") // essa anotação da opção de vc mudar alguns comportamentos da tabela
						// no caso to mudando o nome da entidade la no BD para cargos
public class Cargo {
	
	@Id		//coloca essa anotação para sinalizar para o spring que esse atributo é o meu ID, q uso p contralar minha entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)   	//p ele gerar os valores automáticos p mim, p q eu n precise ficar setando 1, 2, 3... 
					    									//o framework vai fazer automaticamente. a strategia é o IDENTY p gerar o id sequenciados
	private Integer id;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
