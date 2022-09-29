package br.com.alura.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final FuncionarioRepository funcionarioRepository;

	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("\nQUAL AÇÃO DE CARGO DESEJA EXECUTAR?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario por nome:");
			System.out.println("2 - Busca funcionario nome, data contratação e salario maior:");
			System.out.println("3 - Busca funcionario por data contratação: ");
			int action = sc.nextInt();
			switch (action) {
			case 1:
				buscaFuncionarioPorNome(sc);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(sc);
				break;
			case 3:
				buscaFuncionarioDataContratacao(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioPorNome(Scanner sc) {
		System.out.println("Qual nome a pesquisar:");
		String nome = sc.next();	
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner sc) {
		System.out.println("Qual nome deseja pesquisar: ");
		String nome = sc.next();
		
		System.out.println("Qual data contratação deseja pesquisar: ");
		String data = sc.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salario deseja pesquisar: ");
		Double salario = sc.nextDouble();
		
		List<Funcionario> list = funcionarioRepository
				.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioDataContratacao(Scanner sc) {
		System.out.println("Qual data contratação deseja pesquisar: ");
		String data = sc.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
}
