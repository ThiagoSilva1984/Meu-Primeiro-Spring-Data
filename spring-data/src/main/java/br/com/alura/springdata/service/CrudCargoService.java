package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;


//outra classe vai depender dessa, para isso vamos fazer uma anotação
@Service
public class CrudCargoService {
	//classe para criar a lógica para inserir os valores no banco de dados
	
	private Boolean system = true;
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("\nQUAL AÇÃO DE CARGO DESEJA EXECUTAR?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Atualizar");
			int action = sc.nextInt();
			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {
		System.out.println("Descrição do cargo:");
		String descricao = sc.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("CADASTRADO!!!");
	}
	
	private void atualizar(Scanner sc) {
		System.out.println("ID do cargo:");
		int id = sc.nextInt();
		System.out.println("Descrição atualizada do cargo:");
		String descricao = sc.next();		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("ATUALIZADO!!!");
	}
}
