package br.com.alura.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private Boolean system = true;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("\nQUAL AÇÃO DE UNIDADE DE TRABALHO DESEJA EXECUTAR?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			int action = sc.nextInt();
			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {
		System.out.println("Digite o nome da unidade:");
		String nome = sc.next();
		
		System.out.println("Digite o endereço:");
		String endereco = sc.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("CADASTRADO!!!");
	}
	
	private void atualizar(Scanner sc) {
		System.out.println("Digite o id:");
		int id = sc.nextInt();
		
		System.out.println("Digite o nome da unidade:");
		String nome = sc.next();
		
		System.out.println("Digite o endereco da unidade:");
		String endereco = sc.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("ATUALIZADO!!!");
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
}
	
	
	
	
	
	
