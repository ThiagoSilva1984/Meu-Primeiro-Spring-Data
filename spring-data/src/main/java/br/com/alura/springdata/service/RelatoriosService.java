package br.com.alura.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("\nQUAL AÇÃO DE CARGO DESEJA EXECUTAR?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario por nome:");
			int action = sc.nextInt();
			switch (action) {
			case 1:
				buscaFuncionarioPorNome(sc);
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
}
